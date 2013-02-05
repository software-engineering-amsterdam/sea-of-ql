package org.uva.sea.ql.ast.expressions;

public class BinaryExpr extends Expr {
	private Expr left;
	private Expr right;

	public BinaryExpr(Expr l, Expr r) {
		this.left = l;
		this.right = r;
	}

	public final Expr getRight() {
		return this.right;
	}

	public final Expr getLeft() {
		return this.left;
	}
}
