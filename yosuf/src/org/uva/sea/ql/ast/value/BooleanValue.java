package org.uva.sea.ql.ast.value;

import org.uva.sea.ql.ast.Type;
import org.uva.sea.ql.ast.exp.Bools;
import org.uva.sea.ql.ast.exp.ExpressionVisitor;

public class BooleanValue extends Value {

	private final boolean value;

	public BooleanValue(final boolean value) {
		this.value = value;
	}

	@Override
	public <T> T accept(final ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Type getType() {
		return new Bools();
	}

	public boolean getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "BooleanValue [value=" + value + ", Type=" + getType() + "]";
	}

	@Override
	public String getAsString() {
		return String.valueOf(value);
	}
}
