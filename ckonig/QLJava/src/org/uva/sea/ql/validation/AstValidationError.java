package org.uva.sea.ql.validation;

import org.uva.sea.ql.common.QLException;

public class AstValidationError extends QLException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AstValidationError(String msg){
		super(msg);
	}
}
