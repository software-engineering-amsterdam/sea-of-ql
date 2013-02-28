package org.uva.sea.ql.eval.value;


public class BoolVal extends Value {

	private boolean value;
	
	public BoolVal(boolean b){
		value = b;
	}
	
	
	public boolean getValue(){
		return value;
	}

	@Override
	public String toString(){
		return Boolean.toString(value);
	}
	
	//----------- Generic Boolean -------------------------
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
		return new BoolVal(!this.getValue());
	}

	// ----------- Generic Comparative-------------------------
	@Override
	public Value eq(Value arg) {
		return arg.eqBool(this);
	}

	@Override
	public Value nEq(Value arg) {
		return arg.nEqBool(this);
	}
	
	//----------- Bool Boolean -------------------------
	@Override
	protected Value andBool(BoolVal arg) {
		return new BoolVal(arg.getValue() && this.getValue());
	}

	@Override
	protected Value orBool(BoolVal arg) {
		return new BoolVal(arg.getValue() || this.getValue());
	}

	// ----------- Bool Comparative -------------------------
	@Override
	protected Value eqBool(BoolVal arg) {
		return new BoolVal(arg.getValue() == this.getValue());
	}

	@Override
	protected Value nEqBool(BoolVal arg) {
		return new BoolVal(arg.getValue() != this.getValue());
	}

}
