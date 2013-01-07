package org.uva.sea.ql.ast;

public class Eq extends Expr {

	private final Expr left, right;
	
	public Eq(Expr left, Expr right) {
		this.left = left;
		this.right = right;
	}

}
