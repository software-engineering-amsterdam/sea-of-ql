package org.uva.sea.ql.ast;

public class Sub extends Expr {

	private final Expr left, right;

	public Sub(Expr left, Expr right) {
		this.left = left;
		this.right = right;
	}

}
