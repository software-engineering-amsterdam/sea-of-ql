package org.uva.sea.ql.runtime;

public abstract class NumberValue extends Value {

	@Override
	public abstract Number getValue();

	@Override
	public Value greaterThan(Value other) {
		return other.greaterThan(this);
	}

	@Override
	public Value greaterThan(NumberValue other) {
		Double otherValue = (Double)other.getValue();
		Double thisValue = (Double)this.getValue();
		return new BooleanValue(otherValue > thisValue);
	}

	@Override
	public Value greaterThanOrEquals(Value other) {
		return other.greaterThanOrEquals(this);
	}

	@Override
	public Value greaterThanOrEquals(NumberValue other) {
		Double otherValue = (Double)other.getValue();
		Double thisValue = (Double)this.getValue();
		return new BooleanValue(otherValue >= thisValue);
	}

	@Override
	public Value lessThanOrEquals(Value other) {
		return other.lessThanOrEquals(this);
	}

	@Override
	public Value lessThanOrEquals(NumberValue other) {
		Double otherValue = (Double)other.getValue();
		Double thisValue = (Double)this.getValue();
		return new BooleanValue(otherValue <= thisValue);
	}

	@Override
	public Value lessThan(Value other) {
		return other.lessThan(this);
	}

	@Override
	public Value lessThan(NumberValue other) {
		Double otherValue = (Double)other.getValue();
		Double thisValue = (Double)this.getValue();
		return new BooleanValue(otherValue < thisValue);
	}

}
