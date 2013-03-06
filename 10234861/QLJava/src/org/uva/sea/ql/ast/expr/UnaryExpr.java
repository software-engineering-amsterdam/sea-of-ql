package org.uva.sea.ql.ast.expr;

public abstract class UnaryExpr extends Expr {
	
	private Expr arg;

	public UnaryExpr(Expr arg) {
		this.arg = arg;
	}

	public Expr getArg() {
		return arg;
	}
}
