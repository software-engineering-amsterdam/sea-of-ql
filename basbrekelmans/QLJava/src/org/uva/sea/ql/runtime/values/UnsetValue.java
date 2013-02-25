package org.uva.sea.ql.runtime.values;

import org.uva.sea.ql.ast.types.Type;

public class UnsetValue extends Value {

	protected UnsetValue() {

	}

	@Override
	public Value add(final IntegerValue other) {
		return Value.UNSET_VALUE;
	}

	@Override
	public Value add(final MoneyValue other) {
		return Value.UNSET_VALUE;
	}

	@Override
	public Value add(final Value other) {
		return Value.UNSET_VALUE;
	}

	@Override
	public Value and(final BooleanValue other) {
		return new BooleanValue(false);
	}

	@Override
	public Value and(final Value other) {
		return new BooleanValue(false);
	}

	@Override
	public Value divide(final IntegerValue other) {
		return Value.UNSET_VALUE;
	}

	@Override
	public Value divide(final MoneyValue other) {
		return Value.UNSET_VALUE;
	}

	@Override
	public Value divide(final Value other) {
		return Value.UNSET_VALUE;
	}

	@Override
	public Value equals(final Value other) {
		return new BooleanValue(false);
	}

	@Override
	public Type getType() {
		return Type.UNKNOWN;
	}

	@Override
	public Object getValue() {
		return null;
	}

	@Override
	public Value greaterThan(final IntegerValue other) {
		return new BooleanValue(false);
	}

	@Override
	public Value greaterThan(final MoneyValue other) {
		return new BooleanValue(false);
	}

	@Override
	public Value greaterThan(final Value other) {
		return new BooleanValue(false);
	}

	@Override
	public Value greaterThanOrEquals(final IntegerValue other) {
		return new BooleanValue(false);
	}

	@Override
	public Value greaterThanOrEquals(final MoneyValue other) {
		return new BooleanValue(false);
	}

	@Override
	public Value greaterThanOrEquals(final Value other) {
		return new BooleanValue(false);
	}

	@Override
	public Value lessThan(final IntegerValue other) {
		return new BooleanValue(false);
	}

	@Override
	public Value lessThan(final MoneyValue other) {
		return new BooleanValue(false);
	}

	@Override
	public Value lessThan(final Value other) {
		return new BooleanValue(false);
	}

	@Override
	public Value lessThanOrEquals(final IntegerValue other) {
		return new BooleanValue(false);
	}

	@Override
	public Value lessThanOrEquals(final MoneyValue other) {
		return new BooleanValue(false);
	}

	@Override
	public Value lessThanOrEquals(final Value other) {
		return new BooleanValue(false);
	}

	@Override
	public Value multiply(final IntegerValue other) {
		return Value.UNSET_VALUE;
	}

	@Override
	public Value multiply(final MoneyValue other) {
		return Value.UNSET_VALUE;
	}

	@Override
	public Value multiply(final Value other) {
		return Value.UNSET_VALUE;
	}

	@Override
	public Value negate() {
		return Value.UNSET_VALUE;
	}

	@Override
	public Value not() {
		return new BooleanValue(true);
	}

	@Override
	public Value notEquals(final Value other) {
		return Value.UNSET_VALUE;
	}

	@Override
	public Value or(final BooleanValue other) {
		return new BooleanValue(false);
	}

	@Override
	public Value or(final Value other) {
		return new BooleanValue(false);
	}

	@Override
	public Value positive() {
		return Value.UNSET_VALUE;
	}

	@Override
	public Value subtract(final IntegerValue other) {
		return Value.UNSET_VALUE;
	}

	@Override
	public Value subtract(final MoneyValue other) {
		return Value.UNSET_VALUE;
	}

	@Override
	public Value subtract(final Value other) {
		return Value.UNSET_VALUE;
	}

	@Override
	public Value xor(final BooleanValue other) {
		return new BooleanValue(false);
	}

	@Override
	public Value xor(final Value other) {
		return new BooleanValue(false);
	}

}
