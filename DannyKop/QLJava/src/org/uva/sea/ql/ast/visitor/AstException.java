package org.uva.sea.ql.ast.visitor;
/**
 * class: AstException
 * @author Danny
 *
 */
public class AstException extends Exception {

	/**
	 * Warning resolution
	 */
	private static final long serialVersionUID = -262988409549386025L;

	/**
	 * Constructor
	 * @param message - the error message
	 */
	public AstException(String message) {
		super(message);
	}
}
