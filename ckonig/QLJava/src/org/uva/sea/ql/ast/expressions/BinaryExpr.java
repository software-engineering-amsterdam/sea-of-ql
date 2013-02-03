package org.uva.sea.ql.ast.expressions;

public class BinaryExpr extends Expr {
	private Expr left;
	private Expr right;

	public BinaryExpr(Expr left, Expr right) {
		this.left = left;
		this.right = right;
	}

	public Expr getRight() {
		return right;
	}

	public Expr getLeft() {
		return left;
	}
}
