package org.uva.sea.ql.ast.nodes;

public abstract class UnaryExpr extends Expr{
	private final Expr expr;
	protected UnaryExpr(Expr expr){
		this.expr = expr;
	}
	
	public Expr getExpr(){
		return this.expr;
	}
}
