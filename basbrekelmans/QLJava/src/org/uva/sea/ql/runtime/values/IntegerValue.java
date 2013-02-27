package org.uva.sea.ql.runtime.values;

import org.uva.sea.ql.ast.types.Type;

public class IntegerValue extends Value {
	private final long value;

	public IntegerValue(final long value) {
		this.value = value;
	}

	@Override
	public Value add(final IntegerValue other) {
		final Long otherValue = other.getValue();
		return new IntegerValue(otherValue + this.value);
	}

	@Override
	public Value add(final MoneyValue other) {
		final Double otherValue = other.getValue();
		return new MoneyValue(otherValue + this.value);
	}

	@Override
	public Value add(final Value other) {
		return other.add(this);
	}

	@Override
	public Value divide(final IntegerValue other) {
		final Long otherValue = other.getValue();
		return new IntegerValue(otherValue / this.value);
	}

	@Override
	public Value divide(final MoneyValue other) {
		final Double otherValue = other.getValue();
		return new MoneyValue(otherValue / this.value);
	}

	@Override
	public Value divide(final Value other) {
		return other.divide(this);
	}

	@Override
	public Type getType() {
		return Type.INTEGER;
	}

	@Override
	public Long getValue() {
		return this.value;
	}

	@Override
	public Value greaterThan(final IntegerValue other) {
		final long otherValue = other.getValue();
		return new BooleanValue(otherValue > this.value);
	}

	@Override
	public Value greaterThan(final MoneyValue other) {
		final Double otherValue = other.getValue();
		return new BooleanValue(otherValue > this.value);
	}

	@Override
	public Value greaterThan(final Value other) {
		return other.greaterThan(this);
	}

	@Override
	public Value greaterThanOrEquals(final IntegerValue other) {
		final long otherValue = other.getValue();
		return new BooleanValue(otherValue >= this.value);
	}

	@Override
	public Value greaterThanOrEquals(final MoneyValue other) {
		final double otherValue = other.getValue();
		return new BooleanValue(otherValue >= this.value);
	}

	@Override
	public Value greaterThanOrEquals(final Value other) {
		return other.greaterThanOrEquals(this);
	}

	@Override
	public Value lessThan(final IntegerValue other) {
		final long otherValue = other.getValue();
		return new BooleanValue(otherValue < this.value);
	}

	@Override
	public Value lessThan(final MoneyValue other) {
		final Double otherValue = other.getValue();
		return new BooleanValue(otherValue < this.value);
	}

	@Override
	public Value lessThan(final Value other) {
		return other.lessThan(this);
	}

	@Override
	public Value lessThanOrEquals(final IntegerValue other) {
		final long otherValue = other.getValue();
		return new BooleanValue(otherValue <= this.value);
	}

	@Override
	public Value lessThanOrEquals(final MoneyValue other) {
		final Double otherValue = other.getValue();
		return new BooleanValue(otherValue <= this.value);
	}

	@Override
	public Value lessThanOrEquals(final Value other) {
		return other.lessThanOrEquals(this);
	}

	@Override
	public Value multiply(final IntegerValue other) {
		final Long otherValue = other.getValue();
		return new IntegerValue(otherValue * this.value);
	}

	@Override
	public Value multiply(final MoneyValue other) {
		final Double otherValue = other.getValue();
		return new MoneyValue(otherValue * this.value);
	}

	@Override
	public Value multiply(final Value other) {
		return other.multiply(this);
	}

	@Override
	public Value negate() {
		return new IntegerValue(-this.value);
	}

	@Override
	public Value positive() {
		return new IntegerValue(+this.value);
	}

	@Override
	public Value subtract(final IntegerValue other) {
		final Long otherValue = other.getValue();
		return new IntegerValue(otherValue - this.value);
	}

	@Override
	public Value subtract(final MoneyValue other) {
		final Double otherValue = other.getValue();
		return new MoneyValue(otherValue - this.value);
	}

	@Override
	public Value subtract(final Value other) {
		return other.subtract(this);
	}
}
