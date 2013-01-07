package org.uva.sea.ql.ast;

public class And extends Expr {

	private final Expr left, right;
	
	public And(Expr left, Expr right) {
		this.left = left;
		this.right = right;
	}

}
