package org.uva.sea.ql.ast;

import java.util.HashMap;

public class Eq extends BinExpr {

	public Eq(Expr result, Expr rhs) {
		super(result, rhs);
	}

	@Override
	public TypeDescription typeOf(HashMap<Ident, Statement> typeEnv) {
		return new BooleanType();
	}
}
