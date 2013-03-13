package org.uva.sea.ql.eval;

public abstract class Value {

	// TODO Money support
	
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
	
	// Numeric computation (integers)
	
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
	
	// Numeric computation (money)
	
	protected Value addMoney(MoneyValue arg) {
		throw new UnsupportedOperationException();
	}
	
	protected Value divMoney(MoneyValue arg) {
		throw new UnsupportedOperationException();
	}
	
	protected Value mulMoney(MoneyValue arg) {
		throw new UnsupportedOperationException();
	}
	
	protected Value subMoney(MoneyValue arg) {
		throw new UnsupportedOperationException();
	}
	
	// Relational computation (integers)
	
	protected Value eqInt(IntegerValue arg) {
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
	
	protected Value neqInt(IntegerValue arg) {
		throw new UnsupportedOperationException();
	}
	
	// Relational computation (money)
	
	protected Value eqMoney(MoneyValue arg) {
		throw new UnsupportedOperationException();
	}
	
	protected Value geqMoney(MoneyValue arg) {
		throw new UnsupportedOperationException();
	}
	
	protected Value gtMoney(MoneyValue arg) {
		throw new UnsupportedOperationException();
	}
	
	protected Value leqMoney(MoneyValue arg) {
		throw new UnsupportedOperationException();
	}
	
	protected Value ltMoney(MoneyValue arg) {
		throw new UnsupportedOperationException();
	}
	
	protected Value neqMoney(MoneyValue arg) {
		throw new UnsupportedOperationException();
	}
	
}
