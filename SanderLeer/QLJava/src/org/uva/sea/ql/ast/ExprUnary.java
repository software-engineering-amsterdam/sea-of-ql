package org.uva.sea.ql.ast;

public abstract class ExprUnary extends Expr {
	protected final Expr expr;
	
	public ExprUnary(Expr expr) {
		this.expr = expr;
	}

	public Expr getExpr() {
		return expr;
	}
}
