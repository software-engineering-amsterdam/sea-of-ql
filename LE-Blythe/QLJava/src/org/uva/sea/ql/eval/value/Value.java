package org.uva.sea.ql.eval.value;


public abstract class Value {
	
	public abstract String toString();
	
	public boolean isDefined(){
		return true;
	}

	//----------- Generic Numeric -------------------------
	public Value add(Value arg) {
		throw new UnsupportedOperationException();
	}


	public Value div(Value arg) {
		throw new UnsupportedOperationException();
	}

	
	public Value mul(Value arg) {
		throw new UnsupportedOperationException();
	}

	
	public Value sub(Value arg) {
		throw new UnsupportedOperationException();
	}
	
	
	public Value pos() {
		throw new UnsupportedOperationException();
	}
	
	
	public Value neg() {
		throw new UnsupportedOperationException();
	}

	//----------- Generic Boolean -------------------------
	public Value and(Value arg) {
		throw new UnsupportedOperationException();
	}

	
	public Value or(Value arg) {
		throw new UnsupportedOperationException();
	}
	

	public Value not() {
		throw new UnsupportedOperationException();
	}
	
	//----------- Generic Comparative-------------------------
	public Value eq(Value arg) {
		throw new UnsupportedOperationException();
	}
	
	
	public Value gEq(Value arg) {
		throw new UnsupportedOperationException();
	}
	
	
	public Value gt(Value arg) {
		throw new UnsupportedOperationException();
	}
	
	
	public Value lEq(Value arg) {
		throw new UnsupportedOperationException();
	}
	
	
	public Value lt(Value arg) {
		throw new UnsupportedOperationException();
	}
	

	public Value nEq(Value arg) {
		throw new UnsupportedOperationException();
	}
	
	//----------- Int Numeric-------------------------
	protected Value addInt(IntVal arg) {
		throw new UnsupportedOperationException();
	}

	
	protected Value divInt(IntVal arg) {
		throw new UnsupportedOperationException();
	}

	
	protected Value mulInt(IntVal arg) {
		throw new UnsupportedOperationException();
	}

	
	protected Value subInt(IntVal arg) {
		throw new UnsupportedOperationException();
	}
	
	//----------- Int Comparative -------------------------
	protected Value eqInt(IntVal arg) {
		throw new UnsupportedOperationException();
	}
	
	
	protected Value nEqInt(IntVal arg) {
		throw new UnsupportedOperationException();
	}
	
	
	protected Value gEqInt(IntVal arg) {
		throw new UnsupportedOperationException();
	}
	
	
	protected Value gtInt(IntVal arg) {
		throw new UnsupportedOperationException();
	}
	
	
	protected Value lEqInt(IntVal arg) {
		throw new UnsupportedOperationException();
	}
	
	
	protected Value ltInt(IntVal arg) {
		throw new UnsupportedOperationException();
	}
	
	//----------- Bool Boolean -------------------------
	protected Value andBool(BoolVal arg) {
		throw new UnsupportedOperationException();
	}
	
	
	protected Value orBool(BoolVal arg) {
		throw new UnsupportedOperationException();
	}
	
	//----------- Bool Comparative -------------------------
	protected Value eqBool(BoolVal arg) {
		throw new UnsupportedOperationException();
	}
	
	
	protected Value nEqBool(BoolVal arg) {
		throw new UnsupportedOperationException();
	}
	
	//----------- Str Comparative -------------------------
	protected Value eqStr(StrVal arg) {
		throw new UnsupportedOperationException();
	}
	
	
	protected Value nEqStr(StrVal arg) {
		throw new UnsupportedOperationException();
	}
}
