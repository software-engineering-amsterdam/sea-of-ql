package org.uva.sea.ql.ast.traversal.codegeneration.bootstrap;

import java.util.*;

import org.stringtemplate.v4.*;
import org.uva.sea.ql.ast.types.Ident;

/**
 * Bootstrap Javascript Generator.
 * 
 * @author J. Dijkstra
 */
class BootstrapJavascriptGenerator {
	/**
	 * Template File Name.
	 */
	private static final String TEMPLATE_FILE_NAME = "bootstrap_js.stg";

	/**
	 * Template delimiter character.
	 */
	private static final char TEMPLATE_DELIMITER = '$';
	
	/**
	 * Template group file to use. 
	 */
	private final STGroupFile javascriptTemplateGroup;
	
	/**
	 * Init code on top of the javascript.
	 */
	private final StringBuffer initialCode = new StringBuffer();

	/**
	 * Holds amount of references to a specific identifier for code generation.
	 */
	private final Map<Ident, Integer> references = new HashMap<Ident, Integer>();

	/**
	 * Constructor.
	 * 
	 * @param templatesPath path to retrieve the code generation templates (stringtemplates) from.
	 * @param serverBaseURL base URL for the server to use in the front-end code.
	 */
	public BootstrapJavascriptGenerator(final String templatesPath, final String serverBaseURL) {
		final String javascriptTemplateFilePath = String.format("%s/%s", templatesPath, TEMPLATE_FILE_NAME);
		javascriptTemplateGroup = new STGroupFile(javascriptTemplateFilePath, TEMPLATE_DELIMITER, TEMPLATE_DELIMITER);
	
		initServerBaseURL(serverBaseURL);
	}

	/**
	 * Setup the server base URL in javascript. To post to and use for validation.
	 * 
	 * @param serverBaseURL server base URL
	 */
	private void initServerBaseURL(final String serverBaseURL) {
		final ST baseURLDeclarationTemplate = javascriptTemplateGroup.getInstanceOf("server_base_url_declaration");
		baseURLDeclarationTemplate.add("url", serverBaseURL);
		
		initialCode.append(baseURLDeclarationTemplate.render());
	}
	
	/**
	 * Init reference count to an ident.
	 * 
	 * @param id ident
	 */
	public void initIdentReference(final Ident id) {
		references.put(id, 0);
	}
	
	/**
	 * Increase reference count to an ident.
	 * 
	 * @param id ident
	 */
	public void increaseIdentReferenceCount(final Ident id) {
		references.put(id, references.get(id) + 1);
	}
	
	/**
	 * Declare a javascript function.
	 * 
	 * @param id ident
	 * @param expression expression template
	 */	
	public void declareFunction(final Ident id, final ST expression) {
		declareFunction(id.getName(), expression);
		
		// Start counting references
		initIdentReference(id);
	}
	
	/**
	 * Declare a javascript function.
	 * 
	 * @param id id of the variable
	 * @param expression expression template
	 */
	public void declareFunction(final String id, final ST expression) {
		// Store the javascript function in the initialization code
		final ST functionTemplate = javascriptTemplateGroup.getInstanceOf("map_function");
		functionTemplate.add("id", id);
		functionTemplate.add("expression", expression);

		initialCode.append(functionTemplate.render());
	}
	
	/**
	 * Render javascript code.
	 * @return javascript code in a string
	 */
	public String render() {
		final StringBuffer documentReadyBuffer = new StringBuffer();
		final StringBuffer javascriptBuffer = new StringBuffer();

		// Generate functions and initial code and append them to the final javascript code 
		javascriptBuffer.append(initialCode);
		
		// Generate dispatch methods in the document ready
		for (final Ident ident : references.keySet()) {
			// If there is references to the identity, then generate a dispatch method as we know there are dependencies on this identifier
			if (references.get(ident) > 0) {
				final ST dispatchTemplate = javascriptTemplateGroup.getInstanceOf("dispatch_function");
				dispatchTemplate.add("id", ident.getName());
				documentReadyBuffer.append(dispatchTemplate.render());
			}
		}
		
		// Append the document ready code to the final javascript code
		javascriptBuffer.append(getTemplatedDocumentReadyCode(documentReadyBuffer));		
		
		return javascriptBuffer.toString();
	}

	private String getTemplatedDocumentReadyCode(final StringBuffer buffer) {
		final ST documentReadyTemplate = javascriptTemplateGroup.getInstanceOf("document_ready_block");
		documentReadyTemplate.add("code", buffer);
		return documentReadyTemplate.render();
	}
}
