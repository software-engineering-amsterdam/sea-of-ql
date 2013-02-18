package org.uva.sea.ql.util;

/**
 * Exception that could be thrown when trying to open the browser.
 * 
 * @author J. Dijkstra
 */
public class BrowserException extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor.
	 * 
	 * @param exception exception to wrap
	 */
	public BrowserException(final Throwable exception) {
		super("Browser Exception", exception);
	}
}
