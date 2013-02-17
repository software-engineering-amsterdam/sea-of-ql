package org.uva.sea.ql.common;

public class QLException extends Exception {

	private static final long serialVersionUID = -2579764756318893590L;

	public QLException() {
	}

	public QLException(String message) {
		super(message);
	}

	public QLException(Throwable cause) {
		super(cause);
	}

	public QLException(String message, Throwable cause) {
		super(message, cause);
	}

	

}
