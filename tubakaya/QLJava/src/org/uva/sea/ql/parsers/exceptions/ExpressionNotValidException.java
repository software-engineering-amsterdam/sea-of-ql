package org.uva.sea.ql.parsers.exceptions;

import org.uva.sea.ql.ast.Expression;

public class ExpressionNotValidException extends QLException {

	private static final long serialVersionUID = 1L;

	public Expression expression;

	public ExpressionNotValidException(Expression expression) {
		this.expression = expression;
	}

	@Override
	public String ToString() {
		return String
				.format("Invalid expression error occured. Expression type : "
						+ expression.getClass());
	}
}
