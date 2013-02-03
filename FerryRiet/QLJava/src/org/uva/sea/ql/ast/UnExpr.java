package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.nodevisitor.Visitor;
import org.uva.sea.ql.ast.nodevisitor.VisitorResult;

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
