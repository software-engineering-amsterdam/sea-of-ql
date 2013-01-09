package org.uva.sea.ql.ast;

public class Unary extends Expr {

	private final Expr expr;
	
	public Unary(Expr expr) {
		this.expr = expr;
	}
	
}
