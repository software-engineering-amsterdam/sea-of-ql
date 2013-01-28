package org.uva.sea.ql.ast.expr;

import java.util.Map;

import org.uva.sea.ql.ast.types.Type;

public class Neg extends Unary {

	public Neg(Expr x) {
		super(x);
	}

	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		// TODO Auto-generated method stub
		return null;
	}

}
