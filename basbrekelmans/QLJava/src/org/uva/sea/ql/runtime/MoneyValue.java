package org.uva.sea.ql.runtime;

public class MoneyValue extends NumberValue {

	private final double value;
	
	public MoneyValue(double value) {
		this.value = value;
	}
	
	@Override
	public Double getValue() {
		return value;
	}

	@Override
	public Value add(Value other) {
		return other.add(this);
	}

	@Override
	public Value add(IntegerValue other) {
		Double otherValue = (double)other.getValue();
		return new MoneyValue(otherValue + this.value);
		
	}

	@Override
	public Value add(MoneyValue other) {
		Double otherValue = other.getValue();
		return new MoneyValue(otherValue + this.value);
	}

	@Override
	public Value multiply(Value other) {
		return other.multiply(this);
	}

	@Override
	public Value multiply(IntegerValue other) {
		Double otherValue = (double)other.getValue();
		return new MoneyValue(otherValue * this.value);
	}

	@Override
	public Value multiply(MoneyValue other) {
		Double otherValue = other.getValue();
		return new MoneyValue(otherValue * this.value);
	}

	@Override
	public Value divide(Value other) {
		return other.divide(this);
	}

	@Override
	public Value divide(IntegerValue other) {
		Double otherValue = (double)other.getValue();
		return new MoneyValue(otherValue / this.value);
	}

	@Override
	public Value divide(MoneyValue other) {
		Double otherValue = other.getValue();
		return new MoneyValue(otherValue / this.value);
	}

	@Override
	public Value subtract(Value other) {
		return other.subtract(this);
	}

	@Override
	public Value subtract(IntegerValue other) {
		Double otherValue = (double)other.getValue();
		return new MoneyValue(otherValue - this.value);
	}

	@Override
	public Value subtract(MoneyValue other) {
		Double otherValue = other.getValue();
		return new MoneyValue(otherValue - this.value);
	}
	
	@Override
	public Value negate() {
		return new MoneyValue(-value); 
	}
	@Override
	public Value positive() {
		return new MoneyValue(+value); 
	}
}
