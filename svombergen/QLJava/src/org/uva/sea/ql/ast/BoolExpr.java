package org.uva.sea.ql.ast;

public abstract class BoolExpr extends Expr {
	protected Expr leftExpr;
	protected Expr rightExpr;
	
	public BoolExpr(Expr result, Expr rhs){
		leftExpr = result;
		rightExpr = rhs;
	}
	
	public Expr getLeft(){
		return leftExpr;
	}
	
	public Expr getRight(){
		return rightExpr;
	}
	
	@Override
	public String toString(){
		return leftExpr + this.getType() + rightExpr;
	}

}
