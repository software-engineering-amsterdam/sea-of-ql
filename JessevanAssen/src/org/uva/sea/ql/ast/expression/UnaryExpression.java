package org.uva.sea.ql.ast.expression;

public abstract class UnaryExpression implements Expression {
	
	private final Expression expression;
	
	public UnaryExpression(Expression expression) {
		this.expression = expression;
	}
	
	public Expression getExpression() { return expression; }
	
}
