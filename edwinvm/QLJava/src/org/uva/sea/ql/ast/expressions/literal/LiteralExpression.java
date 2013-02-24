package org.uva.sea.ql.ast.expressions.literal;

import org.uva.sea.ql.ast.expressions.Expression;

public abstract class LiteralExpression extends Expression {
	private final Object _value;
	
	protected LiteralExpression(Object value) {
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
		Identifier identifier = (Identifier) obj;
		return ((String)this.getValue()).equals(((String)identifier.getValue()));
	}
}