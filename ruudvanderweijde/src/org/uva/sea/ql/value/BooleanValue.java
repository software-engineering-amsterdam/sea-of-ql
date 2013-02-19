package org.uva.sea.ql.value;


public class BooleanValue extends Value {
	private final Boolean value;
	
	public BooleanValue(Boolean value) {
		this.value = value;
	}

	public Boolean getValue() {
		return value;
	}

	@Override
	public boolean isCompatibleToBooleanType() {
		return true;
	}

	@Override
	public Value and(Value arg) {
		return arg.andBool(this);
	}
	
	@Override
	public Value or(Value arg) {
		return arg.orBool(this);
	}
	
	@Override
	public Value not() {
		return new BooleanValue(!getValue());
	}
	
	@Override
	public Value eq(Value arg) {
		return arg.eqBool(this);
	}
	
	@Override
	public Value neq(Value arg) {
		return arg.neqBool(this);
	}

	@Override
	protected Value andBool(BooleanValue arg) {
		return new BooleanValue(arg.getValue() && getValue());
	}

	@Override
	protected Value orBool(BooleanValue arg) {
		return new BooleanValue(arg.getValue() || getValue());
	}

	@Override
	protected Value eqBool(BooleanValue arg) {
		return new BooleanValue(arg.getValue() == getValue());
	}

	@Override
	protected Value neqBool(BooleanValue arg) {
		return new BooleanValue(arg.getValue() != getValue());
	}
}