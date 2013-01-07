package org.uva.sea.ql.ast;

public class Add extends Expr {

	private final Expr left, right;
	
	public Add(Expr left, Expr right) {
		this.left = left;
		this.right = right;
	}

}
