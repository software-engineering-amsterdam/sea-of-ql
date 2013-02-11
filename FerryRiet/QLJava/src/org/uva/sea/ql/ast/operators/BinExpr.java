package org.uva.sea.ql.ast.operators;

import org.uva.sea.ql.ast.visitor.Visitor;

public abstract class BinExpr extends Expr {
	private final Expr exprLeftHand;
	private final Expr exprRightHand;

	public BinExpr(Expr result, Expr rhs) {
		exprLeftHand = result;
		exprRightHand = rhs;
	}

	public final Expr getExprLeftHand() {
		return exprLeftHand;
	}

	public final Expr getExprRightHand() {
		return exprRightHand;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
}
