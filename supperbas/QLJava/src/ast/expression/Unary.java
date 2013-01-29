package ast.expression;

import ast.Expression;


public abstract class Unary extends Expression {
	
	private final Expression expr;

	public Unary(Expression expr) {
		this.expr = expr;
	}

	public Expression getExpr() {
		return expr;
	}

}
