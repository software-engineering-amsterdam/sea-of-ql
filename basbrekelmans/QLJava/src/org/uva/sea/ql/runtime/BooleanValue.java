package org.uva.sea.ql.runtime;

public class BooleanValue extends Value {

	private final boolean value;
	
	public BooleanValue(boolean value) {
		this.value = value;
	}
	
	@Override
	public Value or(Value other) {
		return other.or(this);
	}

	@Override
	public Value or(BooleanValue other) {
		boolean left = other.getValue();
		boolean right = this.value;
		return new BooleanValue(left || right);
	}

	@Override
	public Value and(Value other) {
		return other.and(this);
	}

	@Override
	public Value and(BooleanValue other) {
		boolean left = other.getValue();
		boolean right = this.value;
		return new BooleanValue(left && right);
	}

	@Override
	public Value xor(Value other) {
		return other.xor(this);
	}

	@Override
	public Value xor(BooleanValue other) {
		boolean left = other.getValue();
		boolean right = this.value;
		return new BooleanValue(left ^ right);
	}

	@Override
	public Boolean getValue() {
		return value;
	}
	
	@Override
	public Value not() {
		return new BooleanValue(!value); 
	}
}
