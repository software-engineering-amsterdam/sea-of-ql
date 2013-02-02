package org.uva.sea.ql.ast.expressions.literal;

import java.util.Map;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Type;

public class Bool extends Expr {
	private final boolean _value;

	public Bool(boolean value) {
		_value = value;
	}

	public boolean getValue() {
		return _value;
	}

	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		return new org.uva.sea.ql.ast.types.Bool();
	}
}