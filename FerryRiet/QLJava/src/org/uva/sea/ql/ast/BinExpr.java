package org.uva.sea.ql.ast;

import org.uva.sea.ql.astnodevisitor.Visitor;
import org.uva.sea.ql.astnodevisitor.VisitorResult;

public abstract class BinExpr extends Expr {
	private final Expr exprLeftHand;
	private final Expr exprRightHand;

	public BinExpr(Expr result, Expr rhs, TypeDescription xtype) {
		super(xtype);
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
	public VisitorResult accept(Visitor visitor) {
		return visitor.visit(this);
	}
}
