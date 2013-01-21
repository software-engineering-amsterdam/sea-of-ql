package org.uva.sea.ql.ast;

import java.util.HashMap;

public class LEq extends BinExpr {

	public LEq(Expr result, Expr rhs) {
		super(result, rhs);
	}

	@Override
	public TypeDescription typeOf(HashMap<Ident, Statement> typeEnv) {
		return new BooleanType();
	}
}
