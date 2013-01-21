package org.uva.sea.ql.ast;

public class LEq extends BinExpr {

	public LEq(Expr result, Expr rhs) {
		super(result, rhs, new BooleanType());
	}
}
