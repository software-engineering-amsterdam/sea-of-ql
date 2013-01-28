package org.uva.sea.ql.runtime;

public abstract class Value {
	public abstract Object getValue();
	
	//addition
	public Value add(Value other) {
		throw new UnsupportedOperationException();
	}
	public Value add(IntegerValue other) {
		throw new UnsupportedOperationException();
	}
	public Value add(MoneyValue other) {
		throw new UnsupportedOperationException();
	}
	
	//multiplication
	public Value multiply(Value other) {
		throw new UnsupportedOperationException();		
	}
	public Value multiply(IntegerValue other) {
		throw new UnsupportedOperationException();
	}
	public Value multiply(MoneyValue other) {
		throw new UnsupportedOperationException();
	}
	
	//division
	public Value divide(Value other) {
		throw new UnsupportedOperationException();		
	}
	public Value divide(IntegerValue other) {
		throw new UnsupportedOperationException();		
	}
	public Value divide(MoneyValue other) {
		throw new UnsupportedOperationException();		
	}
	
	//subtraction
	public Value subtract(Value other) {
		throw new UnsupportedOperationException();		
	}
	public Value subtract(IntegerValue other) {
		throw new UnsupportedOperationException();		
	}
	public Value subtract(MoneyValue other) {
		throw new UnsupportedOperationException();		
	}
	
	//comparisons
	public Value equals(Value other) {
		return new BooleanValue(this.getValue().equals(other.getValue()));
	}
	public Value notEquals(Value other) {
		return new BooleanValue(!this.getValue().equals(other.getValue()));	
	}
	public Value greaterThan(Value other) {
		throw new UnsupportedOperationException();
	}
	public Value greaterThan(NumberValue other) {
		throw new UnsupportedOperationException();
	}
	public Value greaterThanOrEquals(Value other) {
		throw new UnsupportedOperationException();
	}
	public Value greaterThanOrEquals(NumberValue other) {
		throw new UnsupportedOperationException();
	}
	public Value lessThanOrEquals(Value other) {
		throw new UnsupportedOperationException();
	}
	public Value lessThanOrEquals(NumberValue other) {
		throw new UnsupportedOperationException();
	}
	public Value lessThan(Value other) {
		throw new UnsupportedOperationException();
	}
	public Value lessThan(NumberValue other) {
		throw new UnsupportedOperationException();
	}
	//logical
	public Value or(Value other) {
		throw new UnsupportedOperationException();
	}
	public Value or(BooleanValue other) {
		throw new UnsupportedOperationException();
	}
	public Value and(Value other) {
		throw new UnsupportedOperationException();
	}
	public Value and(BooleanValue other) {
		throw new UnsupportedOperationException();
	}
	public Value xor(Value other) {
		throw new UnsupportedOperationException();
	}
	public Value xor(BooleanValue other) {
		throw new UnsupportedOperationException();
	}
	
	public Value not() {
		throw new UnsupportedOperationException();
	}
	public Value negate() {
		throw new UnsupportedOperationException();
	}
	public Value positive() {
		throw new UnsupportedOperationException();
	}
	
}
