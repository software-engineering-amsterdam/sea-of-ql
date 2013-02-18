package org.uva.sea.ql.interpreter;

public class BooleanValue extends Value {

	private final Boolean value;
	
	public BooleanValue(Boolean value) {
		this.value = value;
	}

	public Boolean getValue() {
		return value;
	}
	
	public Value and(Value arg) {
		return arg.andBool(this);
	}
	
	public Value not() {
		return new BooleanValue(!getValue());
	}
	
	public Value or(Value arg) {
		return arg.orBool(this);
	}
	
	protected Value andBool(BooleanValue arg) {
		return new BooleanValue(arg.getValue() && getValue());
	}
	
	protected Value orBool(BooleanValue arg) {
		return new BooleanValue(arg.getValue() || getValue());
	}
	
	public boolean equals(Object other) {
		if (other instanceof BooleanValue) {
			Boolean x = getValue();
			Boolean y = ((BooleanValue)other).getValue();
			return x.equals(y);
		}
		return false;
	}
	
	public String toString() {
		return getValue().toString();
	}
	
}