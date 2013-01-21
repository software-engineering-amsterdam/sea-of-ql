package org.uva.sea.ql.ast;

import org.uva.sea.ql.astnodevisitor.Visitor;
import org.uva.sea.ql.astnodevisitor.VisitorResult;

public abstract class UnExpr extends Expr {
	private final Expr exprRightHand;

	public UnExpr(Expr rhs) {
		exprRightHand = rhs;
	}

	public Expr getExprRightHand() {
		return exprRightHand;
	}

	@Override
	public VisitorResult accept(Visitor visitor) {
		return visitor.visit(this);
	}
}
