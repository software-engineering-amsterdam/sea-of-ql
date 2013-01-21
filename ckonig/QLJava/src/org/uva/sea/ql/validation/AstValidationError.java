package org.uva.sea.ql.validation;

public class AstValidationError extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AstValidationError(String msg){
		super(msg);
	}
}
