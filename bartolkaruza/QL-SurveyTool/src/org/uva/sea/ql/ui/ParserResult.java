package org.uva.sea.ql.ui;

import org.uva.sea.ql.parser.ParserContext;
import org.uva.sea.ql.service.QLFrontEndException;

public class ParserResult {
	
	private ParserContext context;
	private QLFrontEndException exception;
	
	public ParserContext getContext() {
		return context;
	}
	public void setContext(ParserContext context) {
		this.context = context;
	}
	public QLFrontEndException getException() {
		return exception;
	}
	public void setException(QLFrontEndException exception) {
		this.exception = exception;
	}
	
	public boolean hasErrors() {
		return context.hasErrors();
	}

}
