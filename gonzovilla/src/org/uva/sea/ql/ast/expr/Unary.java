package org.uva.sea.ql.ast.expr;

public abstract class Unary extends Expr {
	
	private final Expr expression;

	public Unary(Expr expression) {
		this.expression = expression;
	}

	public Expr getExpression() {
		return expression;
	}
	
}
