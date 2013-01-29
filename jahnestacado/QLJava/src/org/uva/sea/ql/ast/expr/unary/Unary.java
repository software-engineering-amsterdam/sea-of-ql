package org.uva.sea.ql.ast.expr.unary;

import org.uva.sea.ql.ast.expr.Expr;



public abstract class Unary extends Expr {
    private final Expr leftExpr;
	
	protected Unary(Expr leftExpr){
	      this.leftExpr=leftExpr;
	}
	
	public Expr getLeftExpr(){
		return leftExpr;
	}
	

}
