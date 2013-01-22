package org.uva.sea.ql.ast;

import java.util.HashMap;

public class GEq extends BinExpr {

	public GEq(Expr result, Expr rhs) {
		super(result, rhs);
	}

	@Override
	public TypeDescription typeOf(HashMap<Ident, Statement> typeEnv) {
		return new BooleanType();
	}
}
