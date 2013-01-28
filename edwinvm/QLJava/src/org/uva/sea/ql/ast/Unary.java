package org.uva.sea.ql.ast;

public abstract class Unary extends Expr {
	private final Expr _expr;
	
	protected Unary(Expr expr) {
		_expr = expr;
	}
	
	public Expr getExpr() {
		return _expr;
	}
}