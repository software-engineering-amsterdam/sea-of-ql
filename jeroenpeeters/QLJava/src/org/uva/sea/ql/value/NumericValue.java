package org.uva.sea.ql.value;


public abstract class NumericValue implements Value {

	abstract Number getNumberValue();

	@Override
	public Value addInteger(IntegerValue otherValue) {
		return new IntegerValue(otherValue.getValue() + getNumberValue().intValue());
	}

	@Override
	public Value addMoney(MoneyValue otherValue) {
		return new MoneyValue(otherValue.getValue() + getNumberValue().doubleValue());
	}

	@Override
	public Value divInteger(IntegerValue otherValue) {
		return new IntegerValue(otherValue.getValue() / getNumberValue().intValue());
	}

	@Override
	public Value divMoney(MoneyValue otherValue) {
		return new MoneyValue(otherValue.getValue() / getNumberValue().doubleValue());
	}

	@Override
	public Value eqInteger(IntegerValue otherValue) {
		return new BooleanValue(otherValue.getValue() == getNumberValue().intValue());
	}

	@Override
	public Value eqMoney(MoneyValue otherValue) {
		return new BooleanValue(otherValue.getValue() == getNumberValue().doubleValue());
	}

	@Override
	public Value geqInteger(IntegerValue otherValue) {
		return new BooleanValue(otherValue.getValue() >= getNumberValue().intValue());
	}

	@Override
	public Value geqMoney(MoneyValue otherValue) {
		return new BooleanValue(otherValue.getValue() >= getNumberValue().doubleValue());
	}

	@Override
	public Value gtInteger(IntegerValue otherValue) {
		return new BooleanValue(otherValue.getValue() > getNumberValue().intValue());
	}

	@Override
	public Value gtMoney(MoneyValue otherValue) {
		return new BooleanValue(otherValue.getValue() > getNumberValue().doubleValue());
	}

	@Override
	public Value leqInteger(IntegerValue otherValue) {
		return new BooleanValue(otherValue.getValue() > getNumberValue().intValue());
	}

	@Override
	public Value leqMoney(MoneyValue otherValue) {
		return new BooleanValue(otherValue.getValue() > getNumberValue().doubleValue());
	}

	@Override
	public Value ltInteger(IntegerValue otherValue) {
		return new BooleanValue(otherValue.getValue() < getNumberValue().intValue());
	}

	@Override
	public Value ltMoney(MoneyValue otherValue) {
		return new BooleanValue(otherValue.getValue() < getNumberValue().doubleValue());
	}

	@Override
	public Value mulInteger(IntegerValue otherValue) {
		return new IntegerValue(otherValue.getValue() * getNumberValue().intValue());
	}

	@Override
	public Value mulMoney(MoneyValue otherValue) {
		return new MoneyValue(otherValue.getValue() * getNumberValue().doubleValue());
	}

	@Override
	public Value neqInteger(IntegerValue otherValue) {
		return new BooleanValue(otherValue.getValue() != getNumberValue().intValue());
	}

	@Override
	public Value neqMoney(MoneyValue otherValue) {
		return new BooleanValue(otherValue.getValue() != getNumberValue().doubleValue());
	}

	@Override
	public Value subInteger(IntegerValue otherValue) {
		return new IntegerValue(otherValue.getValue() - getNumberValue().intValue());
	}

	@Override
	public Value subMoney(MoneyValue otherValue) {
		return new MoneyValue(otherValue.getValue() - getNumberValue().doubleValue());
	}
	
	@Override
	public Value or(Value otherValue) {
		throw new UnsupportedOperationException(this.getClass().getName() + " does not support OR operation.");
	}

	@Override
	public Value not() {
		throw new UnsupportedOperationException(this.getClass().getName() + " does not support NOT operation.");
	}

	@Override
	public Value and(Value otherValue) {
		throw new UnsupportedOperationException(this.getClass().getName() + " does not support AND operation.");
	}
	
	@Override
	public Value andBool(BooleanValue otherValue) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value eqBool(BooleanValue otherValue) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value neqBool(BooleanValue otherValue) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Value orBool(BooleanValue otherValue) {
		throw new UnsupportedOperationException();
	}

}