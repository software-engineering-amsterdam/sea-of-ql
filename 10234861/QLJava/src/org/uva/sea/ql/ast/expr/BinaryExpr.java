package org.uva.sea.ql.ast.expr;

public abstract class BinaryExpr extends Expr {

	private Expr lhs;
	private Expr rhs;

	protected BinaryExpr(Expr lhs, Expr rhs) {
		this.lhs = lhs;
		this.rhs = rhs;
	}

	public Expr getLeft() {
		return lhs;
	}

	public Expr getRight() {
		return rhs;
	}
}
