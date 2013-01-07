package org.uva.sea.ql.ast;

public class Or extends Expr {

	private final Expr left, right;

	public Or(Expr left, Expr right) {
		this.left = left;
		this.right = right;
	}

}
