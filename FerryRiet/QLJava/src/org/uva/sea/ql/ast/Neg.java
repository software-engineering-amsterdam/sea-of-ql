package org.uva.sea.ql.ast;

import java.util.HashMap;

public class Neg extends UnExpr {

	public Neg(Expr x) {
		super(x);
	}

	@Override
	public TypeDescription typeOf(HashMap<Ident, Statement> typeEnv) {
		return new NumeralType();
	}
}
