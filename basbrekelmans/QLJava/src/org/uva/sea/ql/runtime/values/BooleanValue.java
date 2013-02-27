package org.uva.sea.ql.runtime.values;

import org.uva.sea.ql.ast.types.Type;

public class BooleanValue extends Value {

	private final boolean value;

	public BooleanValue(final boolean value) {
		this.value = value;
	}

	@Override
	public Value and(final BooleanValue other) {
		final boolean left = other.getValue();
		final boolean right = this.value;
		return new BooleanValue(left && right);
	}

	@Override
	public Value and(final Value other) {
		return other.and(this);
	}

	@Override
	public Type getType() {
		return Type.BOOLEAN;
	}

	@Override
	public Boolean getValue() {
		return this.value;
	}

	@Override
	public Value not() {
		return new BooleanValue(!this.value);
	}

	@Override
	public Value or(final BooleanValue other) {
		final boolean left = other.getValue();
		final boolean right = this.value;
		return new BooleanValue(left || right);
	}

	@Override
	public Value or(final Value other) {
		return other.or(this);
	}

	@Override
	public Value xor(final BooleanValue other) {
		final boolean left = other.getValue();
		final boolean right = this.value;
		return new BooleanValue(left ^ right);
	}

	@Override
	public Value xor(final Value other) {
		return other.xor(this);
	}
}
