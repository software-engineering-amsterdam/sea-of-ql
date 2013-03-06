package org.uva.sea.ql.value;

public abstract class Value {
	public boolean isCompatibleToIntegerType() { return false; }
	public boolean isCompatibleToNumericType() { return false; }
	public boolean isCompatibleToStringType() { return false; }
	public boolean isCompatibleToBooleanType() { return false; }
	
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

	public Value and(Value arg) {
		throw new UnsupportedOperationException();
	}

	public Value eq(Value arg) {
		throw new UnsupportedOperationException();
	}
	
	public Value geq(Value arg) {
		throw new UnsupportedOperationException();
	}
	
	public Value gt(Value arg) {
		throw new UnsupportedOperationException();
	}
	
	public Value lt(Value arg) {
		throw new UnsupportedOperationException();
	}
	
	public Value leq(Value arg) {
		throw new UnsupportedOperationException();
	}
	
	public Value neq(Value arg) {
		throw new UnsupportedOperationException();
	}
	
	public Value or(Value arg) {
		throw new UnsupportedOperationException();
	}

	public Value neg() {
		throw new UnsupportedOperationException();
	}
	
	public Value pos() {
		throw new UnsupportedOperationException();
	}
	
	public Value not() {
		throw new UnsupportedOperationException();
	}
	
	// Integer functions
	protected Value addInt(IntegerValue arg) {
		throw new UnsupportedOperationException();
	}
	
	protected Value divInt(IntegerValue arg) {
		throw new UnsupportedOperationException();
	}
	
	protected Value mulInt(IntegerValue arg) {
		throw new UnsupportedOperationException();
	}
	
	protected Value subInt(IntegerValue arg) {
		throw new UnsupportedOperationException();
	}
	
	protected Value geqInt(IntegerValue arg) {
		throw new UnsupportedOperationException();
	}
	
	protected Value gtInt(IntegerValue arg) {
		throw new UnsupportedOperationException();
	}
	
	protected Value leqInt(IntegerValue arg) {
		throw new UnsupportedOperationException();
	}
	
	protected Value ltInt(IntegerValue arg) {
		throw new UnsupportedOperationException();
	}
	
	// Boolean functions
	protected Value andBool(BooleanValue arg) {
		throw new UnsupportedOperationException();
	}
	
	protected Value orBool(BooleanValue arg) {
		throw new UnsupportedOperationException();
	}
	
	protected Value eqBool(BooleanValue arg) {
		throw new UnsupportedOperationException();
	}
	
	protected Value neqBool(BooleanValue arg) {
		throw new UnsupportedOperationException();
	}
}
