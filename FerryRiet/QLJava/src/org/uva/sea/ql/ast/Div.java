package org.uva.sea.ql.ast;

import java.util.HashMap;

public class Div extends BinExpr {

	public Div(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}

	@Override
	public TypeDescription typeOf(HashMap<Ident, Statement> typeEnv) {
		return new NumeralType();
	}
}
