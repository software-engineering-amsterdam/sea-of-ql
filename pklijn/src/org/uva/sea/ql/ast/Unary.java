package org.uva.sea.ql.ast;

public abstract class Unary extends Expr {
	private Expr arg;
	
	public Unary(Expr arg) {
		this.arg = arg;
	}
	
	public Expr getArg() {
		return arg;
	}
}
