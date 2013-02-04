package org.uva.sea.ql.ast.expression;

public abstract class BinaryExpression implements Expression {
	
	private final Expression leftExpression,
	                   rightExpression;
	
	public BinaryExpression(Expression leftExpression, Expression rightExpression) {
		this.leftExpression = leftExpression;
		this.rightExpression = rightExpression;
	}
	
	public Expression getLeftExpression() { return leftExpression; }
	public Expression getRightExpression() { return rightExpression; }
}
