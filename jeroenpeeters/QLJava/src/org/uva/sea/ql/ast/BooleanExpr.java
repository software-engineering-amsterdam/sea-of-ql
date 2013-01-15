package org.uva.sea.ql.ast;

public abstract class BooleanExpr extends BinaryExpr {
	
	public BooleanExpr(final Expr lhs, final Expr rhs){
		super(lhs, rhs);
	}
	
}