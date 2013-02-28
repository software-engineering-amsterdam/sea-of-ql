package org.uva.sea.ql.parser;

public class ParseError extends Exception {

	private static final long serialVersionUID = 1L;
	private final String message;

	public ParseError(final String msg) {
		super(msg);
		message = msg;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
