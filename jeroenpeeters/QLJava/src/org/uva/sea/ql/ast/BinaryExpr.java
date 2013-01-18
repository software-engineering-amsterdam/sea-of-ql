package org.uva.sea.ql.ast;

public abstract class BinaryExpr extends Expr {

	protected final Expr lhs, rhs;
	
	public BinaryExpr(final Expr lhs, final Expr rhs){
		this.lhs = lhs;
		this.rhs = rhs;
	}
	
}