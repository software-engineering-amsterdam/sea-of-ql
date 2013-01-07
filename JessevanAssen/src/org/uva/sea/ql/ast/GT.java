package org.uva.sea.ql.ast;

public class GT extends Expr {

	private final Expr left, right;

	public GT(Expr left, Expr right) {
		this.left = left;
		this.right = right;
	}


}
