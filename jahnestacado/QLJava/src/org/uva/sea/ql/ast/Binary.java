package org.uva.sea.ql.ast;



public abstract class Binary extends Expr {

	private final Expr leftExpr;
	private final Expr rightExpr;

	public Binary(Expr leftExpr, Expr rightExpr) {
		this.leftExpr = leftExpr;
		this.rightExpr = rightExpr;
	}

	public Expr getLeftExpr() {
		return leftExpr;
	}

	public Expr getRightExpr() {
		return rightExpr;
	}

	

}
