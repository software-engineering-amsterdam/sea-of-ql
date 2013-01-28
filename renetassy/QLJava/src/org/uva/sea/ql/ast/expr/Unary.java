package org.uva.sea.ql.ast.expr;

public class Unary extends Expr {

	private Expr arg;

	public Unary(Expr arg) {
		this.arg=arg;
	}
	
	public Expr getArg() {
		return arg;
	}
	
}
