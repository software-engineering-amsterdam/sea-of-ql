package org.uva.sea.ql.ast;

public class Eq extends BinExpr {

	public Eq(Expr result, Expr rhs) {
		super(result, rhs, new BooleanType());
	}
}
