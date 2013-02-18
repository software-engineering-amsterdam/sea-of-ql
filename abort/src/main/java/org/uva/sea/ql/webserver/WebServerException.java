package org.uva.sea.ql.webserver;

/**
 * Represents an exception that could be thrown by a webserver.
 * 
 * @author J. Dijkstra
 */
public class WebServerException extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor.
	 * 
	 * @param exception
	 *            exception to wrap
	 */
	public WebServerException(final Throwable exception) {
		super("Server Exception", exception);
	}
}
