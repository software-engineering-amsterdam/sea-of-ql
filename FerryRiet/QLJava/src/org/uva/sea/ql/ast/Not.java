package org.uva.sea.ql.ast;

import java.util.HashMap;

public class Not extends UnExpr {

	public Not(Expr x) {
		super(x);
	}

	@Override
	public TypeDescription typeOf(HashMap<Ident, Statement> typeEnv) {
		return new BooleanType();
	}
}
