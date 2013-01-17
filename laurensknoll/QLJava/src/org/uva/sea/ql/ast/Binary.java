package org.uva.sea.ql.ast;

public class Binary extends Expr {

	private final Expr lhsExpr;
	private final Expr rhsExpr;
	
	public Binary(Expr lhsExpr, Expr rhsExpr) {
		this.lhsExpr = lhsExpr;
		this.rhsExpr = rhsExpr;
	}
	
	public Expr getLeftHandSideExpression() {
		return this.lhsExpr;
	}
	
	public Expr getRightHandSideExpression() {
		return this.rhsExpr;
	}
}
