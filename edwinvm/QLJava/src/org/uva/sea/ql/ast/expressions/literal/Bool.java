package org.uva.sea.ql.ast.expressions.literal;

import java.util.Map;

import org.uva.sea.ql.ast.Type;
import org.uva.sea.ql.ast.expressions.LiteralExpr;

public class Bool extends LiteralExpr {

	public Bool(boolean value) {
		super(value);
	}

	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		return new org.uva.sea.ql.ast.types.Bool();
	}
}