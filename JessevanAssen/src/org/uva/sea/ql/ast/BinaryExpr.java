package org.uva.sea.ql.ast;

public abstract class BinaryExpr extends Expr {
	
	private final Expr leftExpression, 
	                   rightExpression;
	
	public BinaryExpr(Expr leftExpression, Expr rightExpression) {
		this.leftExpression = leftExpression;
		this.rightExpression = rightExpression;
	}
	
	public Expr getLeftExpression() { return leftExpression; }
	public Expr getRightExpression() { return rightExpression; }
}
