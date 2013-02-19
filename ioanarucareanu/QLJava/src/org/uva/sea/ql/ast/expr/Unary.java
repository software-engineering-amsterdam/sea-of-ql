package org.uva.sea.ql.ast.expr;


public abstract class Unary extends Expr {
    private final Expr expr;
	
	protected Unary(Expr expr){
	      this.expr=expr;
	}
	
	public Expr getExpr(){
		return expr;
	}
	

}
