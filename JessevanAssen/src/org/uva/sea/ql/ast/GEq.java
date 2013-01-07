package org.uva.sea.ql.ast;

public class GEq extends Expr {

	private final Expr left, right;
	
	public GEq(Expr left, Expr right) {
		this.left = left;
		this.right = right;
	}

}
