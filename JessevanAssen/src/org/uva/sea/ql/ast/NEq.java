package org.uva.sea.ql.ast;

public class NEq extends Expr {

	private final Expr left, right;

	public NEq(Expr left, Expr right) {
		this.left = left;
		this.right = right;
	}

}
