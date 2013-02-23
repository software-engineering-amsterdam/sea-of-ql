package org.uva.sea.ql.ast.expressions.literal;

import org.uva.sea.ql.ast.expressions.Expr;

public abstract class LiteralExpr extends Expr {
	private final Object _value;
	
	protected LiteralExpr(Object value) {
		_value = value;
	}
	
	public Object getValue() {
		return _value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((_value == null) ? 0 : _value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		Ident identifier = (Ident) obj;
		return ((String)this.getValue()).equals(((String)identifier.getValue()));
	}
}