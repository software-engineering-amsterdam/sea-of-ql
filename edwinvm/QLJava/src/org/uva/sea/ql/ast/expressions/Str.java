package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.ast.Expr;

public class Str extends Expr {
	private final String _value;

	public Str(String value) {
		_value = value;
	}

	public String getValue() {
		return _value;
	}
}