package org.uva.sea.ql.parser.evaluator.result;

import org.uva.sea.ql.parser.evaluator.result.visitor.ValueVisitor;

public abstract class Value {

	public abstract <T> T accept(ValueVisitor<T> visitor);

	public abstract Object getValue();

	public boolean isDefined() {
		return true;
	}

	@Override
	public int hashCode() {
		return getValue().hashCode();
	}

	/*
	 * Adding (overloaded)
	 */
	public Value add(Value val) {
		throw new UnsupportedOperationException();
	}

	public Value addInt(IntValue val) {
		throw new UnsupportedOperationException();
	}

	public Value addStr(StrValue val) {
		throw new UnsupportedOperationException();
	}

	/*
	 * Arithmetic
	 */
	public Value sub(Value val) {
		throw new UnsupportedOperationException();
	}

	public Value subInt(IntValue val) {
		throw new UnsupportedOperationException();
	}

	public Value mul(Value val) {
		throw new UnsupportedOperationException();
	}

	public Value mulInt(IntValue val) {
		throw new UnsupportedOperationException();
	}

	public Value div(Value val) {
		throw new UnsupportedOperationException();
	}

	public Value divInt(IntValue val) {
		throw new UnsupportedOperationException();
	}

	public Value pos() {
		throw new UnsupportedOperationException();
	}

	public Value neg() {
		throw new UnsupportedOperationException();
	}

	/*
	 * Relational (eq, neq "overloaded")
	 */
	public Value lt(Value val) {
		throw new UnsupportedOperationException();
	}

	public Value ltInt(IntValue val) {
		throw new UnsupportedOperationException();
	}

	public Value leq(Value val) {
		throw new UnsupportedOperationException();
	}

	public Value leqInt(IntValue val) {
		throw new UnsupportedOperationException();
	}

	public Value eq(Value val) {
		throw new UnsupportedOperationException();
	}

	public Value eqInt(IntValue val) {
		throw new UnsupportedOperationException();
	}

	public Value eqBool(BoolValue val) {
		throw new UnsupportedOperationException();
	}

	public Value eqStr(StrValue val) {
		throw new UnsupportedOperationException();
	}

	public Value neq(Value val) {
		throw new UnsupportedOperationException();
	}

	public Value neqInt(IntValue val) {
		throw new UnsupportedOperationException();
	}

	public Value neqBool(BoolValue val) {
		throw new UnsupportedOperationException();
	}

	public Value neqStr(StrValue val) {
		throw new UnsupportedOperationException();
	}

	public Value geq(Value val) {
		throw new UnsupportedOperationException();
	}

	public Value geqInt(IntValue val) {
		throw new UnsupportedOperationException();
	}

	public Value gt(Value val) {
		throw new UnsupportedOperationException();
	}

	public Value gtInt(IntValue val) {
		throw new UnsupportedOperationException();
	}

	/*
	 * Boolean
	 */
	public Value not() {
		throw new UnsupportedOperationException();
	}

	public Value and(Value val) {
		throw new UnsupportedOperationException();
	}

	public Value andBool(BoolValue val) {
		throw new UnsupportedOperationException();
	}

	public Value or(Value val) {
		throw new UnsupportedOperationException();
	}

	public Value orBool(BoolValue val) {
		throw new UnsupportedOperationException();
	}

}
