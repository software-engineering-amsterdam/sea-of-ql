package org.uva.sea.ql.ast.expr.grouping;


public abstract class BooleanExpr extends Expr {

	public BooleanExpr(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}

}
