package org.uva.sea.ql.ast.expressions;

public abstract class UnaryExpression extends Expression {
	private final Expression _expression;
	
	protected UnaryExpression(Expression expression) {
		_expression = expression;
	}
	
	public Expression getExpression() {
		return _expression;
	}
}