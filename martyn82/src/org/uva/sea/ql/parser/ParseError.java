package org.uva.sea.ql.parser;

/**
 * Represents a parse error.
 */
public class ParseError extends Exception {
	/**
	 * Holds the unique version ID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructs a new parse error.
	 * 
	 * @param message
	 * @param lineNumber
	 * @param columnNumber
	 */
	public ParseError( String message ) {
		super( message );
	}
}
