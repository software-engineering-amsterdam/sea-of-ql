package org.uva.sea.ql.validation;

import org.uva.sea.ql.common.VisitorException;

public class AstValidationError extends VisitorException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AstValidationError(String msg){
		super(msg);
	}
}
