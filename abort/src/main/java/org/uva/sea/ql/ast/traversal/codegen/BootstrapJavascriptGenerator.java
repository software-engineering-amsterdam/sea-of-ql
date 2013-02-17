package org.uva.sea.ql.ast.traversal.codegen;

import java.util.*;

import org.stringtemplate.v4.*;
import org.uva.sea.ql.ast.types.Ident;

public class BootstrapJavascriptGenerator {
	private final StringBuffer initialCode = new StringBuffer();
	private final STGroupFile javascriptTemplateGroup = new STGroupFile("templates/bootstrap_js.stg", '$', '$');

	// Amount of references to a specific identifier
	private final Map<Ident, Integer> references = new HashMap<Ident, Integer>();

	public void initIdentReference(final Ident id) {
		references.put(id, 0);
	}
	
	public void increaseIdentReferenceCount(final Ident id) {
		references.put(id, references.get(id) + 1);
	}
	
	public void declareFunction(final Ident id, final ST expression) {
		declareFunction(id.getName(), expression);
		
		// Start counting references
		initIdentReference(id);
	}
	
	public void declareFunction(final String id, final ST expression) {
		// Store the javascript function in the initialization code
		final ST functionTemplate = javascriptTemplateGroup.getInstanceOf("generate_map_function");
		functionTemplate.add("id", id);
		functionTemplate.add("expression", expression);

		initialCode.append(functionTemplate.render());
	}
	
	public String render() {
		final StringBuffer documentReadyBuffer = new StringBuffer();
		final StringBuffer javascriptBuffer = new StringBuffer();

		// Generate functions and initial code
		javascriptBuffer.append(initialCode);
		
		// Generate dispatch methods in the document ready
		for (final Ident ident : references.keySet()) {
			if (references.get(ident) > 0) {
				final ST dispatchTemplate = javascriptTemplateGroup.getInstanceOf("generate_dispatch_function");
				dispatchTemplate.add("id", ident.getName());
				documentReadyBuffer.append(dispatchTemplate.render());
			}
		}
		
		javascriptBuffer.append(getTemplatedDocumentReadyCode(documentReadyBuffer));		
		
		return javascriptBuffer.toString();
	}

	private String getTemplatedDocumentReadyCode(final StringBuffer buffer) {
		final ST documentReadyTemplate = javascriptTemplateGroup.getInstanceOf("document_ready_block");
		documentReadyTemplate.add("code", buffer);
		return documentReadyTemplate.render();
	}
}
