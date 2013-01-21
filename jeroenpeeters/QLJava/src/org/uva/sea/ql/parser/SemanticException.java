package org.uva.sea.ql.parser;

public class SemanticException extends RuntimeException {

	public SemanticException() {
		super();
	}

	public SemanticException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public SemanticException(String arg0) {
		super(arg0);
	}

	public SemanticException(Throwable arg0) {
		super(arg0);
	}

}
