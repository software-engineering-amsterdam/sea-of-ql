package org.uva.sea.ql.ast;

import org.uva.sea.ql.astnodevisitor.Visitor;

public abstract class UnExpr extends Expr {
	private final Expr exprRightHand;

	public UnExpr(Expr rhs) {
		exprRightHand = rhs;
	}

	public Expr getExprRightHand() {
		return exprRightHand;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
