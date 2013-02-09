package org.uva.sea.ql.ast.expr.value;


public class IntegerValue extends Value<Integer> {

	public IntegerValue() {
		super(0);
	}
	
	public IntegerValue(Integer value) {
		super(value);
	}
	
	public BooleanValue lessThan(IntegerValue value) {
		return new BooleanValue(getValue() < value.getValue());
	}
	
	public BooleanValue greaterThan(IntegerValue value) {
		return new BooleanValue(getValue() > value.getValue());
	}
	
	public BooleanValue equalTo(IntegerValue value) {
		return new BooleanValue(getValue() == value.getValue());
	}
	
	public BooleanValue notEqualTo(IntegerValue value) {
		return equalTo(value).not();
	}
	
	public BooleanValue lessOrEqualTo(IntegerValue value) {
		return new BooleanValue(lessThan(value).or(equalTo(value)));
	}
	
	public BooleanValue greaterOrEqualTo(IntegerValue value) {
		return new BooleanValue(greaterThan(value).or(equalTo(value)));
	}
	
	public IntegerValue add(IntegerValue value) {
		return new IntegerValue(getValue() + value.getValue());
	}
	
	public IntegerValue substract(IntegerValue value) {
		return new IntegerValue(getValue() - value.getValue());
	}
	
	public IntegerValue multiplyBy(IntegerValue value) {
		return new IntegerValue(getValue() * value.getValue());
	}
	
	public IntegerValue divideBy(IntegerValue value) {
		return new IntegerValue(getValue() / value.getValue());
	}
	
}
