package org.uva.sea.ql.ast.expressions.literal;

import java.util.Map;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Type;

public class Str extends Expr {
	private final String _value;

	public Str(String value) {
		_value = value;
	}

	public String getValue() {
		return _value;
	}

	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		return new org.uva.sea.ql.ast.types.Str();
	}
}