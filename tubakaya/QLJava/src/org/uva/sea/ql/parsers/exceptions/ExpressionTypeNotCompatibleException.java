package org.uva.sea.ql.parsers.exceptions;

import org.uva.sea.ql.ast.Expression;

public class ExpressionTypeNotCompatibleException extends QLException {
	
	private static final long serialVersionUID = 1L;

	private Expression expression;
	
	public ExpressionTypeNotCompatibleException(Expression expression) {
		this.expression = expression;
	}

	public Expression getExpression() {
		return expression;
	}

	@Override
	public String ToString() {
		return String.format("Expression type is not compatible to operate. Expression class : {0}",expression.getClass());
	}
}
