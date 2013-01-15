package org.uva.sea.ql.ast;

import org.uva.sea.ql.astnodevisitor.Visitor;

public abstract class BinExpr extends Expr {
	private final Expr exprLeftHand;
	private final Expr exprRightHand;

	public BinExpr(Expr result, Expr rhs) {
		exprLeftHand = result;
		exprRightHand = rhs;
	}

	public Expr getExprLeftHand() {
		return exprLeftHand;
	}

	public Expr getExprRightHand() {
		return exprRightHand;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
