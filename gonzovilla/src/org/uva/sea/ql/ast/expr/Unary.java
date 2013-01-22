package org.uva.sea.ql.ast.expr;

public abstract class Unary extends Expr {
	
	private final Expr arg;

	public Unary(Expr arg) {
		this.arg = arg;
	}

	public Expr getArg() {
		return arg;
	}
	
}
