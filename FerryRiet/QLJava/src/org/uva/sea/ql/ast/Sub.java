package org.uva.sea.ql.ast;

import java.util.HashMap;

public class Sub extends BinExpr {

	public Sub(Expr result, Expr rhs) {
		super(result, rhs);
	}

	@Override
	public TypeDescription typeOf(HashMap<Ident, Statement> typeEnv) {
		return new NumeralType();
	}
}
