package org.uva.sea.ql.runtime;

public class IntegerValue extends Value {
	private long value;
	public IntegerValue(long value) {
		this.value = value;
	}
	@Override
	public Long getValue() {
		return value;
	}
	@Override
	public Value add(Value other) {
		return other.add(this);
	}
	@Override
	public Value add(IntegerValue other) {
		Long otherValue = other.getValue();
		return new IntegerValue(otherValue + this.value);
	}
	@Override
	public Value add(MoneyValue other) {
		Double otherValue = other.getValue();
		return new MoneyValue(otherValue + (double)this.value);
	}
	@Override
	public Value multiply(Value other) {
		return other.multiply(this);
	}
	@Override
	public Value multiply(IntegerValue other) {
		Long otherValue = other.getValue();
		return new IntegerValue(otherValue * this.value);
	}
	@Override
	public Value multiply(MoneyValue other) {
		Double otherValue = other.getValue();
		return new MoneyValue(otherValue * (double)this.value);
	}
	@Override
	public Value divide(Value other) {
		return other.divide(this);
	}
	@Override
	public Value divide(IntegerValue other) {
		Long otherValue = other.getValue();
		return new IntegerValue(otherValue / this.value);
	}
	@Override
	public Value divide(MoneyValue other) {
		Double otherValue = other.getValue();
		return new MoneyValue(otherValue / (double)this.value);
	}
	@Override
	public Value subtract(Value other) {
		return other.subtract(this);
	}
	@Override
	public Value subtract(IntegerValue other) {
		Long otherValue = other.getValue();
		return new IntegerValue(otherValue - this.value);
	}
	@Override
	public Value subtract(MoneyValue other) {
		Double otherValue = other.getValue();
		return new MoneyValue(otherValue - (double)this.value);
	}
	
	@Override
	public Value negate() {
		return new IntegerValue(-value); 
	}
	@Override
	public Value positive() {
		return new IntegerValue(+value); 
	}
}
