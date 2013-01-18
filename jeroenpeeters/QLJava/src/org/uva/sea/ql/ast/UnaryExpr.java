package org.uva.sea.ql.ast;

public abstract class UnaryExpr extends Expr {

	protected final Expr expr;
	
	public UnaryExpr(final Expr expr){
		this.expr = expr;
	}
	
}