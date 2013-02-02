package org.uva.sea.ql.ast.values;

import java.util.Map;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Type;

public class Int extends Expr {
	private final int _value;

	public Int(int value) {
		_value = value;
	}

	public int getValue() {
		return _value;
	}

	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		return new org.uva.sea.ql.ast.types.Int();
	}	
}