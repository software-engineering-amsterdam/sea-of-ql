package org.uva.sea.ql.ast;

public class Div extends Expr {

	private final Expr left, right;
	
	public Div(Expr left, Expr right) {
		this.left = left;
		this.right = right;
	}

}
