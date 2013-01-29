package ast.expression;

import ast.Expression;


public abstract class Unary extends Expression {
	
	private final Expression expression;

	public Unary(Expression expression) {
		this.expression = expression;
	}

	public Expression getExpression() {
		return expression;
	}

}
