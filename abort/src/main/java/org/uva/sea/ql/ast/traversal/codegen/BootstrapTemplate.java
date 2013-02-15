package org.uva.sea.ql.ast.traversal.codegen;

import org.stringtemplate.v4.ST;

public class BootstrapTemplate {
	private ST javascriptDocumentReadyCode;
	private ST javascriptInitialCode;
	private ST bodyCode;
	
	public BootstrapTemplate(final ST javascriptDocumentReadyCode,
			final ST javascriptInitialCode, final ST bodyCode) {
		this.javascriptDocumentReadyCode = javascriptDocumentReadyCode;
		this.javascriptInitialCode = javascriptInitialCode;
		this.bodyCode = bodyCode;
	}
	
	public BootstrapTemplate() {
		
	}
	
	public void setJavascriptDocumentReadyCode(ST javascriptDocumentReadyCode) {
		this.javascriptDocumentReadyCode = javascriptDocumentReadyCode;
	}
	
	public void setJavascriptInitialCode(ST javascriptInitialCode) {
		this.javascriptInitialCode = javascriptInitialCode;
	}
	
	public void setBodyCode(ST bodyCode) {
		this.bodyCode = bodyCode;
	}
	
	public ST getBodyCode() {
		return bodyCode;
	}
	
	public ST getJavascriptDocumentReadyCode() {
		return javascriptDocumentReadyCode;
	}
	
	public ST getJavascriptInitialCode() {
		return javascriptInitialCode;
	}
}
