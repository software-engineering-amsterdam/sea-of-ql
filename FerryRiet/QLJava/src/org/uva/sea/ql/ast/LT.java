package org.uva.sea.ql.ast;

public class LT extends BinExpr {

	public LT(Expr result, Expr rhs) {
		super(result, rhs, new BooleanType());
	}
}
