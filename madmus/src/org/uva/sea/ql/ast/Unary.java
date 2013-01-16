package org.uva.sea.ql.ast;

public abstract class Unary extends Expr {
	
	private final Expr arg;
	
	protected Unary(Expr arg) {
		this.arg = arg;
	}
	
	protected Expr getArg() {
		return this.arg;
	}

}
