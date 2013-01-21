package org.uva.sea.ql.visitor;

public class VisitorException extends Exception {

	private static final long serialVersionUID = -2579764756318893590L;

	public VisitorException() {
	}

	public VisitorException(String message) {
		super(message);
	}

	public VisitorException(Throwable cause) {
		super(cause);
	}

	public VisitorException(String message, Throwable cause) {
		super(message, cause);
	}

	

}
