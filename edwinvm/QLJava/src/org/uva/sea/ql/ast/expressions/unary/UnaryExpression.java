package org.uva.sea.ql.ast.expressions.unary;

import org.uva.sea.ql.ast.expressions.Expression;

public abstract class UnaryExpression extends Expression {
	private final Expression _expression;
	
	protected UnaryExpression(Expression expression) {
		_expression = expression;
	}
	
	public Expression getExpression() {
		return _expression;
	}
}