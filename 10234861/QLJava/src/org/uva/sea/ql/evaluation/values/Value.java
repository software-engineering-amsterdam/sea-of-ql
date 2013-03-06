package org.uva.sea.ql.evaluation.values;

public abstract class Value {

	abstract public Object getValue();

	public Value add(Value arg) {
		throw new UnsupportedOperationException();
	}

	protected Value addInt(Int arg) {
		throw new UnsupportedOperationException();
	}

	public Value sub(Value arg) {
		throw new UnsupportedOperationException();
	}

	protected Value subInt(Int arg) {
		throw new UnsupportedOperationException();
	}

	public Value mul(Value arg) {
		throw new UnsupportedOperationException();
	}

	protected Value mulInt(Int arg) {
		throw new UnsupportedOperationException();
	}

	public Value div(Value arg) {
		throw new UnsupportedOperationException();
	}

	protected Value divInt(Int arg) {
		throw new UnsupportedOperationException();
	}

	public Value neg() {
		throw new UnsupportedOperationException();
	}

	public Value pos() {
		throw new UnsupportedOperationException();
	}

	// logic

	public Value and(Value arg) {
		throw new UnsupportedOperationException();
	}

	protected Value andBool(Bool arg) {
		throw new UnsupportedOperationException();
	}

	public Value or(Value arg) {
		throw new UnsupportedOperationException();
	}

	protected Value orBool(Bool arg) {
		throw new UnsupportedOperationException();
	}

	public Value not() {
		throw new UnsupportedOperationException();
	}

	// comparisons

	public Value eq(Value arg) {
		throw new UnsupportedOperationException();
	}

	protected Value eqBool(Bool arg) {
		throw new UnsupportedOperationException();
	}

	public Value notEq(Value arg) {
		throw new UnsupportedOperationException();
	}

	protected Value notEqBool(Bool arg) {
		throw new UnsupportedOperationException();
	}

	public Value greater(Value arg) {
		throw new UnsupportedOperationException();
	}

	protected Value greaterInt(Int arg) {
		throw new UnsupportedOperationException();
	}

	public Value greaterOrEq(Value arg) {
		throw new UnsupportedOperationException();
	}

	protected Value greaterOrEqInt(Int arg) {
		throw new UnsupportedOperationException();
	}

	public Value less(Value arg) {
		throw new UnsupportedOperationException();
	}

	protected Value lessInt(Int arg) {
		throw new UnsupportedOperationException();
	}

	public Value lessOrEq(Value arg) {
		throw new UnsupportedOperationException();
	}

	protected Value lessOrEqInt(Int arg) {
		throw new UnsupportedOperationException();
	}
}
