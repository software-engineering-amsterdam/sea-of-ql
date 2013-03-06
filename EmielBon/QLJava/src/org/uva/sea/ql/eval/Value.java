package org.uva.sea.ql.eval;

public abstract class Value {

	// Logical operators
	
	public Value and(Value arg) {
		throw new UnsupportedOperationException();
	}
	
	public Value not() {
		throw new UnsupportedOperationException();
	}
	
	public Value or(Value arg) {
		throw new UnsupportedOperationException();
	}	
	
	// Numeric operations
	
	public Value add(Value arg) {
		throw new UnsupportedOperationException();
	}
	
	public Value div(Value arg) {
		throw new UnsupportedOperationException();
	}
	
	public Value mul(Value arg) {
		throw new UnsupportedOperationException();
	}
	
	public Value neg() {
		throw new UnsupportedOperationException();
	}
	
	public Value pos() {
		throw new UnsupportedOperationException();
	}
	
	public Value sub(Value arg) {
		throw new UnsupportedOperationException();
	}
	
	// Relational operators
	
	public Value eq(Value arg) {
		throw new UnsupportedOperationException();
	}
	
	public Value geq(Value arg) {
		throw new UnsupportedOperationException();
	}
	
	public Value gt(Value arg) {
		throw new UnsupportedOperationException();
	}
	
	public Value leq(Value arg) {
		throw new UnsupportedOperationException();
	}
	
	public Value lt(Value arg) {
		throw new UnsupportedOperationException();
	}
	
	public Value neq(Value arg) {
		throw new UnsupportedOperationException();
	}
	
	// Logical double dispatch

	protected Value andBool(BooleanValue arg) {
		throw new UnsupportedOperationException();
	}
	
	protected Value notBool(BooleanValue arg) {
		throw new UnsupportedOperationException();
	}
	
	protected Value orBool(BooleanValue arg) {
		throw new UnsupportedOperationException();
	}
	
	// Numeric computation
	
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
	
	// Relational computation
	
	
}
