package org.uva.sea.ql.ast;

public class GT extends BinExpr {

	public GT(Expr result, Expr rhs) {
		super(result, rhs, new BooleanType());
	}
}
