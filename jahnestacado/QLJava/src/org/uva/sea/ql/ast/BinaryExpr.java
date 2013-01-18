package org.uva.sea.ql.ast;



public abstract class BinaryExpr extends Expr {

	private final Expr exprLeftHand;
	private final Expr exprRightHand;

	public BinaryExpr(Expr result, Expr rhs) {
		exprLeftHand = result;
		exprRightHand = rhs;
	}

	public Expr getExprLeftHand() {
		return exprLeftHand;
	}

	public Expr getExprRightHand() {
		return exprRightHand;
	}

	

}
