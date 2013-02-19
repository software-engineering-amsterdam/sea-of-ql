package org.uva.sea.ql.ast.operators;

public abstract class UnExpr extends Expr {
	private final Expr exprRightHand;

	public UnExpr(Expr rhs) {
		exprRightHand = rhs;
	}

	public Expr getExprRightHand() {
		return exprRightHand;
	}
}
