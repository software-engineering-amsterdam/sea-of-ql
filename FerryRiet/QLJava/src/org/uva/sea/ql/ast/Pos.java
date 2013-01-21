package org.uva.sea.ql.ast;

public class Pos extends UnExpr {

	public Pos(Expr x) {
		super(x, new NumeralType());
	}
}
