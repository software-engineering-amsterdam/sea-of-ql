package org.uva.sea.ql.ast.expr.grouping;

public abstract class InEqualityExpr extends Expr {

	public InEqualityExpr(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}
}
