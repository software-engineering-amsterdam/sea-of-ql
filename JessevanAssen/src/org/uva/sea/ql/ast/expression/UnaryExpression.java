package org.uva.sea.ql.ast.expression;

public abstract class UnaryExpression implements Expression {
	
	private final Expression innerExpression;
	
	public UnaryExpression(Expression innerExpression) {
		this.innerExpression = innerExpression;
	}
	
	public Expression getExpression() { return innerExpression; }
	
}
