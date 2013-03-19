package org.uva.sea.ql.evaluator.values;

public class BoolValue extends Value {
	
	private final Boolean value;
	
	public BoolValue(Boolean value) {
		this.value = value;
	}
	
	public Boolean getValue() {
		return this.value;
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
	public Value not() {
		return this.notBool();
	}
	
	@Override
	public Value and(Value arg) {
		return arg.andBool(this);
	}
	
	@Override
	public Value or(Value arg) {
		return arg.orBool(this);
	}
	
	
	// Computations
	
	@Override
	protected Value eqBool(BoolValue arg) {
		return new BoolValue(arg.getValue() == this.getValue());
	}
	
	@Override
	protected Value neqBool(BoolValue arg) {
		return new BoolValue(arg.getValue() != this.getValue());
	}
	
	@Override 
	protected Value notBool() {
		return new BoolValue(!this.getValue());
	}
	
	@Override
	protected Value orBool(BoolValue arg) {
		return new BoolValue(arg.getValue() || this.getValue());
	}
	
	@Override
	protected Value andBool(BoolValue arg) {
		return new BoolValue(arg.getValue() && this.getValue());
	}
	
}
