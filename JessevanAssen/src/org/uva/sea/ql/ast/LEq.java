package org.uva.sea.ql.ast;

public class LEq extends Expr {

	private final Expr left, right;

	public LEq(Expr left, Expr right) {
		this.left = left;
		this.right = right;
	}

}
