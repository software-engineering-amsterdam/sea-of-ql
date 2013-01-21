package org.uva.sea.ql.ast;

import java.util.HashMap;

public class GT extends BinExpr {

	public GT(Expr result, Expr rhs) {
		super(result, rhs);
	}

	@Override
	public TypeDescription typeOf(HashMap<Ident, Statement> typeEnv) {
		return new BooleanType();
	}
}
