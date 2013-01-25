package org.uva.sea.ql.ast;

import java.util.Map;

import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.values.*;

public class Eq extends Binary {

	public Eq(Expr left, Expr right) {
		super(left, right);
	}

	@Override
	public Value eval() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		return new org.uva.sea.ql.ast.types.BoolType();
	}

}
