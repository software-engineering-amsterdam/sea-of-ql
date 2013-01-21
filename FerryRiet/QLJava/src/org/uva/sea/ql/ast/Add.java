package org.uva.sea.ql.ast;

public class Add extends BinExpr {

	public Add(Expr result, Expr rhs) {
		super(result, rhs, new NumeralType());
	}
}
