package org.uva.sea.ql.ast.expr.grouping;

public abstract class EqualityExpr extends Expr {

	public EqualityExpr(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}
}
