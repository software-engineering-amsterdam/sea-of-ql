package org.uva.sea.ql.ast;

public class Sub extends BinExpr {

	public Sub(Expr result, Expr rhs) {
		super(result, rhs, new NumeralType());
	}
}
