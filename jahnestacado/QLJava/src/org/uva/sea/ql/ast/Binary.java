package org.uva.sea.ql.ast;



public abstract class Binary extends Expr {

	private final Expr exprLeftHand;
	private final Expr exprRightHand;

	public Binary(Expr result, Expr rhs) {
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
