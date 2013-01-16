package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.ast.Expr;

public class Bool extends Expr {
	private final boolean _value;

	public Bool(boolean value) {
		_value = value;
	}

	public boolean getValue() {
		return _value;
	}
}