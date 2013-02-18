package org.uva.sea.ql.interpreter;

public abstract class Value {

	// Logical operators
	
	public Value and(Value arg) {
		throw new UnsupportedOperationException();
	}
	
	public Value not(Value arg) {
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

	protected Value andBool(Bool arg) {
		throw new UnsupportedOperationException();
	}
	
	protected Value notBool(Bool arg) {
		throw new UnsupportedOperationException();
	}
	
	protected Value orBool(Bool arg) {
		throw new UnsupportedOperationException();
	}
	
	// Numeric computation
	
	protected Value addInt(Int arg) {
		throw new UnsupportedOperationException();
	}
	
	protected Value divInt(Int arg) {
		throw new UnsupportedOperationException();
	}
	
	protected Value mulInt(Int arg) {
		throw new UnsupportedOperationException();
	}
	
	protected Value subInt(Int arg) {
		throw new UnsupportedOperationException();
	}
	
	// Relational computation
	
	
}
