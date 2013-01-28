package org.uva.sea.ql.ast.values;

import org.uva.sea.ql.ast.Expr;

public class Money extends Expr {
	private final double _value;

	public Money(double value) {
		_value = value;
	}

	public double getValue() {
		return _value;
	}	
}