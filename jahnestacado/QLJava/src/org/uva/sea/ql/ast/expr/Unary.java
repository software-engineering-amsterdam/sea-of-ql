package org.uva.sea.ql.ast.expr;



public abstract class Unary extends Expr {
    private final Expr leftExpr;
	
	protected Unary(Expr leftExpr){
	      this.leftExpr=leftExpr;
	}
	
	public Expr getLeftExpr(){
		return leftExpr;
	}
	

}
