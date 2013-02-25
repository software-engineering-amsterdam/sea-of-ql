package org.uva.sea.ql.runtime.values;

import org.uva.sea.ql.ast.types.Type;

public abstract class Value {
	public static final Value UNSET_VALUE = new UnsetValue();

	public Value add(final IntegerValue other) {
		throw new UnsupportedOperationException();
	}

	public Value add(final MoneyValue other) {
		throw new UnsupportedOperationException();
	}

	public Value add(final Value other) {
		throw new UnsupportedOperationException();
	}

	public Value and(final BooleanValue other) {
		throw new UnsupportedOperationException();
	}

	public Value and(final Value other) {
		throw new UnsupportedOperationException();
	}

	public Value divide(final IntegerValue other) {
		throw new UnsupportedOperationException();
	}

	public Value divide(final MoneyValue other) {
		throw new UnsupportedOperationException();
	}

	public Value divide(final Value other) {
		throw new UnsupportedOperationException();
	}

	// comparisons
	public Value equals(final Value other) {
		if (other == Value.UNSET_VALUE) {
			return Value.UNSET_VALUE;
		}
		return new BooleanValue(this.getValue().equals(other.getValue()));
	}

	public abstract Type getType();

	public abstract Object getValue();

	public Value greaterThan(final IntegerValue other) {
		throw new UnsupportedOperationException();
	}

	public Value greaterThan(final MoneyValue other) {
		throw new UnsupportedOperationException();
	}

	public Value greaterThan(final Value other) {
		throw new UnsupportedOperationException();
	}

	public Value greaterThanOrEquals(final IntegerValue other) {
		throw new UnsupportedOperationException();
	}

	public Value greaterThanOrEquals(final MoneyValue other) {
		throw new UnsupportedOperationException();
	}

	public Value greaterThanOrEquals(final Value other) {
		throw new UnsupportedOperationException();
	}

	public Value lessThan(final IntegerValue other) {
		throw new UnsupportedOperationException();
	}

	public Value lessThan(final MoneyValue other) {
		throw new UnsupportedOperationException();
	}

	public Value lessThan(final Value other) {
		throw new UnsupportedOperationException();
	}

	public Value lessThanOrEquals(final IntegerValue other) {
		throw new UnsupportedOperationException();
	}

	public Value lessThanOrEquals(final MoneyValue other) {
		throw new UnsupportedOperationException();
	}

	public Value lessThanOrEquals(final Value other) {
		throw new UnsupportedOperationException();
	}

	public Value multiply(final IntegerValue other) {
		throw new UnsupportedOperationException();
	}

	public Value multiply(final MoneyValue other) {
		throw new UnsupportedOperationException();
	}

	// multiplication
	public Value multiply(final Value other) {
		throw new UnsupportedOperationException();
	}

	public Value negate() {
		throw new UnsupportedOperationException();
	}

	public Value not() {
		throw new UnsupportedOperationException();
	}

	public Value notEquals(final Value other) {
		if (other == Value.UNSET_VALUE) {
			return Value.UNSET_VALUE;
		}
		return new BooleanValue(!this.getValue().equals(other.getValue()));
	}

	public Value or(final BooleanValue other) {
		throw new UnsupportedOperationException();
	}

	// logical
	public Value or(final Value other) {
		throw new UnsupportedOperationException();
	}

	public Value positive() {
		throw new UnsupportedOperationException();
	}

	public Value subtract(final IntegerValue other) {
		throw new UnsupportedOperationException();
	}

	public Value subtract(final MoneyValue other) {
		throw new UnsupportedOperationException();
	}

	// subtraction
	public Value subtract(final Value other) {
		throw new UnsupportedOperationException();
	}

	public Value xor(final BooleanValue other) {
		throw new UnsupportedOperationException();
	}

	public Value xor(final Value other) {
		throw new UnsupportedOperationException();
	}
}
