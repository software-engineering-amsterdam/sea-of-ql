package org.uva.sea.ql.ast.binaryexpr;

import org.uva.sea.ql.ast.Expr;

public abstract class BinaryExpr extends Expr {
	protected Expr leftExpr;
	protected Expr rightExpr;
	
	public BinaryExpr(Expr lhs, Expr rhs){
		leftExpr = lhs;
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
		return leftExpr + typeOf().toString() + rightExpr;
	}

}
