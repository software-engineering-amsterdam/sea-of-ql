package org.uva.sea.ql.eval.value;


public class UndefinedVal extends Value {
	
	public boolean isDefined(){
		return false;
	}

	@Override
	public String toString() {
		return "Undefined";
	}

	// ----------- Generic Numeric -------------------------
	@Override
	public Value add(Value arg) {
		return new UndefinedVal();
	}

	@Override
	public Value div(Value arg) {
		return new UndefinedVal();
	}

	@Override
	public Value mul(Value arg) {
		return new UndefinedVal();
	}

	@Override
	public Value sub(Value arg) {
		return new UndefinedVal();
	}

	@Override
	public Value pos() {
		return new UndefinedVal();
	}

	@Override
	public Value neg() {
		return new UndefinedVal();
	}

	// ----------- Generic Boolean -------------------------
	@Override
	public Value and(Value arg) {
		return new UndefinedVal();
	}

	@Override
	public Value or(Value arg) {
		return new UndefinedVal();
	}

	@Override
	public Value not() {
		return new UndefinedVal();
	}

	// ----------- Generic Comparative-------------------------
	@Override
	public Value eq(Value arg) {
		return new UndefinedVal();
	}

	@Override
	public Value gEq(Value arg) {
		return new UndefinedVal();
	}

	@Override
	public Value gt(Value arg) {
		return new UndefinedVal();
	}

	@Override
	public Value lEq(Value arg) {
		return new UndefinedVal();
	}

	@Override
	public Value lt(Value arg) {
		return new UndefinedVal();
	}

	@Override
	public Value nEq(Value arg) {
		return new UndefinedVal();
	}

	// ----------- Int Numeric-------------------------
	@Override
	protected Value addInt(IntVal arg) {
		return new UndefinedVal();
	}

	@Override
	protected Value divInt(IntVal arg) {
		return new UndefinedVal();
	}

	@Override
	protected Value mulInt(IntVal arg) {
		return new UndefinedVal();
	}

	@Override
	protected Value subInt(IntVal arg) {
		return new UndefinedVal();
	}

	// ----------- Int Comparative -------------------------
	@Override
	protected Value eqInt(IntVal arg) {
		return new UndefinedVal();
	}

	@Override
	protected Value nEqInt(IntVal arg) {
		return new UndefinedVal();
	}

	@Override
	protected Value gEqInt(IntVal arg) {
		return new UndefinedVal();
	}

	@Override
	protected Value gtInt(IntVal arg) {
		return new UndefinedVal();
	}

	@Override
	protected Value lEqInt(IntVal arg) {
		return new UndefinedVal();
	}

	@Override
	protected Value ltInt(IntVal arg) {
		return new UndefinedVal();
	}

	// ----------- Bool Boolean -------------------------
	@Override
	protected Value andBool(BoolVal arg) {
		return new UndefinedVal();
	}

	@Override
	protected Value orBool(BoolVal arg) {
		return new UndefinedVal();
	}

	// ----------- Bool Comparative -------------------------
	@Override
	protected Value eqBool(BoolVal arg) {
		return new UndefinedVal();
	}

	@Override
	protected Value nEqBool(BoolVal arg) {
		return new UndefinedVal();
	}

	// ----------- Str Comparative -------------------------
	@Override
	protected Value eqStr(StrVal arg) {
		return new UndefinedVal();
	}

	@Override
	protected Value nEqStr(StrVal arg) {
		return new UndefinedVal();
	}
}
