package org.uva.sea.ql.ast.operators;

import org.uva.sea.ql.ast.visitor.Visitor;

public abstract class UnExpr extends Expr {
	private final Expr exprRightHand;

	public UnExpr(Expr rhs) {
		exprRightHand = rhs;
	}

	public Expr getExprRightHand() {
		return exprRightHand;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
}
