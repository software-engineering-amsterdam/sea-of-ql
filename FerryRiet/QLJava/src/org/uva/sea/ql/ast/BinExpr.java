package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.nodevisitor.Visitor;
import org.uva.sea.ql.ast.nodevisitor.VisitorResult;

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
	public VisitorResult accept(Visitor visitor) {
		return visitor.visit(this);
	}
}
