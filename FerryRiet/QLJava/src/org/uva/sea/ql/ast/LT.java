package org.uva.sea.ql.ast;

import java.util.HashMap;

public class LT extends BinExpr {

	public LT(Expr result, Expr rhs) {
		super(result, rhs);
	}

	@Override
	public TypeDescription typeOf(HashMap<Ident, Statement> typeEnv) {
		return new BooleanType();
	}
}
