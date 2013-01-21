package org.uva.sea.ql.ast.expr.grouping;

public abstract class ArithmeticExpr extends Expr {

	public ArithmeticExpr(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}

}
