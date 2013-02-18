package org.uva.sea.ql.ast.traversal.codegeneration.base;

/**
 * Exception that could be thrown while generating webcode.
 * 
 * @author J. Dijkstra
 */
public class WebGenerationException extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor.
	 * 
	 * @param exception exception
	 */
	public WebGenerationException(final Throwable exception) {
		super("Web Generation Exception", exception);
	}
}
