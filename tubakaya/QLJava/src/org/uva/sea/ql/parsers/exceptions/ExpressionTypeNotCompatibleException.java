package org.uva.sea.ql.parsers.exceptions;

import org.uva.sea.ql.core.dom.Expression;

public class ExpressionTypeNotCompatibleException extends Exception {
	
	private static final long serialVersionUID = 1L;

	private Expression expression;
	
	public ExpressionTypeNotCompatibleException(Expression expression) {
		this.expression = expression;
	}

	public Expression getExpression() {
		return expression;
	}

}
