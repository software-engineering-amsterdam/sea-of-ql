package org.uva.sea.ql.ast.expr;

public abstract class Binary extends Expr {

	private final Expr leftExpr;
	private final Expr rightExpr;

	protected Binary(Expr leftExpr, Expr rightExpr) {
		this.leftExpr = leftExpr;
		this.rightExpr = rightExpr;
	}

	public Expr getLeftExpr() {
		return leftExpr;
	}

	public Expr getRightExpr() {
		return rightExpr;
	}
	
	public abstract String getOperator();

	@Override
	public String toString() {
		return "Binary [" + leftExpr + getOperator() + rightExpr + "]";
	}
	
	
	
}
