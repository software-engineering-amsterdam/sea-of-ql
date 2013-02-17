package org.uva.sea.ql.interpretation.exception;

import org.uva.sea.ql.common.QLException;

public class InterpreterException extends QLException {

	private static final long serialVersionUID = 8706690059457294427L;

	public InterpreterException() {

	}

	public InterpreterException(String message) {
		super(message);
	}

}
