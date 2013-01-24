package org.uva.sea.ql.interpreter;

import org.uva.sea.ql.visitor.VisitorException;

public class InterpreterException extends VisitorException {

	public InterpreterException(String message) {
		super(message);
	}

	private static final long serialVersionUID = 8706690059457294427L;

}
