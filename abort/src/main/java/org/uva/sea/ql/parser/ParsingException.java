package org.uva.sea.ql.parser;

public class ParsingException extends Exception {
	private static final long serialVersionUID = 1L;

	public ParsingException(Throwable exception) {
		super("Parsing Error", exception);
	}
}
