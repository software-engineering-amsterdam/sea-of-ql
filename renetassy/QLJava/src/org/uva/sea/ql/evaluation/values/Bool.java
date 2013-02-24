package org.uva.sea.ql.evaluation.values;


public class Bool extends Value {

	private final boolean value;
	
	public Bool(boolean value) {
		this.value=value;
	}
	
	@Override
	public Boolean getValue() {
		return value;
	}
	
	@Override
	public Value and(Value arg) {
		return arg.andBool(this);
	}

	@Override
	protected Value andBool(Bool arg) {
		return new Bool(arg.getValue() && getValue());
	}
	
	@Override
	public Value or(Value arg) {
		return arg.orBool(this);
	}

	@Override
	protected Value orBool(Bool arg) {
		return new Bool(arg.getValue() || getValue());
	}
	
	@Override
	public Value eq(Value arg) {
		return arg.eqBool(this);
	}

	@Override
	protected Value eqBool(Bool arg) {
		return new Bool(arg.getValue().equals(this.getValue()));
	}
	
	@Override
	public Value notEq(Value arg) {
		return arg.notEqBool(this);
	}

	@Override
	protected Value notEqBool(Bool arg) {
		return new Bool(!arg.getValue().equals(this.getValue()));
	}
	
	@Override
	public Value not() {
		return new Bool(!this.value);
	}

}
