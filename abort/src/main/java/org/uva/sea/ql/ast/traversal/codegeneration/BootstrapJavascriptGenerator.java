package org.uva.sea.ql.ast.traversal.codegeneration;

import java.util.*;

import org.stringtemplate.v4.*;
import org.uva.sea.ql.ast.types.Ident;

class BootstrapJavascriptGenerator {
	private static final String TEMPLATE_FILE_NAME = "bootstrap_js.stg";
	private static final char TEMPLATE_DELIMITER = '$';
	
	private final STGroupFile javascriptTemplateGroup;
	
	private final StringBuffer initialCode = new StringBuffer();

	// Amount of references to a specific identifier
	private final Map<Ident, Integer> references = new HashMap<Ident, Integer>();

	public BootstrapJavascriptGenerator(final String templatesPath, final String serverBaseURL) {
		final String javascriptTemplateFilePath = String.format("%s/%s", templatesPath, TEMPLATE_FILE_NAME);
		javascriptTemplateGroup = new STGroupFile(javascriptTemplateFilePath, TEMPLATE_DELIMITER, TEMPLATE_DELIMITER);
	
		initServerPort(serverBaseURL);
	}
	
	private void initServerPort(final String serverBaseURL) {
		final ST baseURLDeclarationTemplate = javascriptTemplateGroup.getInstanceOf("server_base_url_declaration");
		baseURLDeclarationTemplate.add("url", serverBaseURL);
		
		initialCode.append(baseURLDeclarationTemplate.render());
	}
	
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
