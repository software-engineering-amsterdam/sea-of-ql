package org.uva.sea.ql.interpreter;

public class Bool extends Value {

	private final boolean value;
	
	public Bool(boolean value) {
		this.value = value;
	}

	public boolean getValue() {
		return value;
	}
	
	public Value and(Value arg) {
		return arg.andBool(this);
	}
	
	public Value not() {
		return new Bool( !getValue() );
	}
	
	public Value or(Value arg) {
		return arg.orBool(this);
	}
	
	protected Value addBool(Bool arg) {
		return new Bool(arg.getValue() && getValue());
	}
	
	protected Value orBool(Bool arg) {
		return new Bool(arg.getValue() || getValue());
	}
	
}