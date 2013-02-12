package org.uva.sea.ql.ast.value;

import org.uva.sea.ql.visitor.NaturalVisitor;
import org.uva.sea.ql.visitor.ValuableVisitor;

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
	public BooleanValue accept(final ValuableVisitor visitor) {
		return visitor.visit(this);
	}

	@Override
	public Nature getNature() {
		return Nature.BOOLEAN;
	}

	public boolean getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "BooleanValue [value=" + value + ", Nature=" + getNature() + "]";
	}
}
