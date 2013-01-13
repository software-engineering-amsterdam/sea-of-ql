package org.uva.sea.ql.ast.expr;

public abstract class UnaryExpr extends Expr {
	
	private final Expr expression;
	
	public UnaryExpr(Expr expression) {
		this.expression = expression;
	}
	
	public Expr getExpression() { return expression; }
	
}
