package org.uva.sea.ql.ast.expr;



public class Unary extends Expr {

	private Expr x;

	public Unary(Expr x) {
		this.x=x;
	}
	
}
