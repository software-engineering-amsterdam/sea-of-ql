package org.uva.sea.ql.ast.expr.value;

public class IntegerVal extends Val {
	
	private int value;
	
	public IntegerVal() {
		
	}
	
	public IntegerVal(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	public IntegerVal add(IntegerVal value) {
		return new IntegerVal(getValue() + value.getValue());
	}

	public IntegerVal substract(IntegerVal value) {
		return new IntegerVal(getValue() - value.getValue());
	}

	public IntegerVal multiplyBy(IntegerVal value) {
		return new IntegerVal(getValue() * value.getValue());
	}

	public IntegerVal divideBy(IntegerVal value) {
		return new IntegerVal(getValue() / value.getValue());
	}
	
	public BooleanVal lessThan(IntegerVal value) {
		return new BooleanVal(getValue() < value.getValue());
	}
	
	public BooleanVal greaterThan(IntegerVal value) {
		return new BooleanVal(getValue() > value.getValue());
	}
	
	public BooleanVal equalTo(IntegerVal value) {
		return new BooleanVal(getValue() == value.getValue());
	}
	
	public BooleanVal notEqualTo(IntegerVal value) {
		return equalTo(value).not();
	}
	
	public BooleanVal lessOrEqualTo(IntegerVal value) {
		return new BooleanVal(lessThan(value).or(equalTo(value)));
	}
	
	public BooleanVal greaterOrEqualTo(IntegerVal value) {
		return new BooleanVal(greaterThan(value).or(equalTo(value)));
	}

	@Override
	public String toString() {
		return "IntegerVal [value=" + value + "]";
	}


}
