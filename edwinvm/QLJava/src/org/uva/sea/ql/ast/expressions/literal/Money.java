package org.uva.sea.ql.ast.expressions.literal;

import java.util.Map;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Type;

public class Money extends Expr {
	private final double _value;

	public Money(double value) {
		_value = value;
	}

	public double getValue() {
		return _value;
	}

	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		return new org.uva.sea.ql.ast.types.Money();
	}	
}