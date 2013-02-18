package org.uva.sea.ql.ast.value;

import org.uva.sea.ql.ast.exp.Bools;
import org.uva.sea.ql.ast.exp.Nature;
import org.uva.sea.ql.visitor.ExpressionVisitor;
import org.uva.sea.ql.visitor.NaturalVisitor;

public class BooleanValue extends Value<BooleanValue> {

	private final boolean value;

	public BooleanValue(final boolean value) {
		this.value = value;
	}

	@Override
	public <T> T accept(final NaturalVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public BooleanValue accept(final ExpressionVisitor visitor) {
		return visitor.visit(this);
	}

	@Override
	public Nature getNature() {
		return new Bools();
	}

	public boolean getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "BooleanValue [value=" + value + ", Nature=" + getNature() + "]";
	}

	@Override
	public String getAsString() {
		return String.valueOf(value);
	}
}
