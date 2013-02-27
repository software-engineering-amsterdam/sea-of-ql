package org.uva.sea.ql.ast.expr;

public abstract class Binary extends Expr {
	private final Expr left;
	private final Expr right;

	public Binary(Expr left, Expr right) {
		this.left = left;
		this.right = right;
	}

	public Expr getLeft() {
		return left;
	}

	public Expr getRight() {
		return right;
	}
	
}
