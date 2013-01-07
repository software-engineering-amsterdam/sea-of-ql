package org.uva.sea.ql.ast;

public class Mul extends Expr {

	private final Expr left, right;
	
	public Mul(Expr left, Expr right) {
		this.left = left;
		this.right = right;
	}

}
