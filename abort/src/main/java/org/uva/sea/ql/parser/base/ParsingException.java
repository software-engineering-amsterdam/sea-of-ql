package org.uva.sea.ql.parser.base;

/**
 * Parsing exception that could be thrown when parsing fails.
 * 
 * @author J. Dijkstra
 */
public class ParsingException extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor.
	 * 
	 * @param exception
	 *            exception to wrap
	 */
	public ParsingException(final Throwable exception) {
		super("Parsing Exception", exception);
	}
}
