package org.uva.sea.ql.parser.evaluator.result;

import org.uva.sea.ql.parser.evaluator.result.visitor.ValueVisitor;

public class UndefinedValue extends Value {

	@Override
	public UndefinedValue getValue() {
		return this;
	}

	@Override
	public <T> T accept(ValueVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public boolean isDefined() {
		return false;
	}

	@Override
	public Value add(Value val) {
		return this;
	}

	@Override
	public Value addInt(IntValue val) {
		return this;
	}

	@Override
	public Value addStr(StrValue val) {
		return this;
	}

	/*
	 * Rest of the arithmetical operations
	 */
	@Override
	public Value sub(Value val) {
		return this;
	}

	@Override
	public Value subInt(IntValue val) {
		return this;
	}

	@Override
	public Value mul(Value val) {
		return this;
	}

	@Override
	public Value mulInt(IntValue val) {
		return this;
	}

	@Override
	public Value div(Value val) {
		return this;
	}

	@Override
	public Value divInt(IntValue val) {
		return this;
	}

	@Override
	public Value pos() {
		return this;
	}

	@Override
	public Value neg() {
		return this;
	}

	/*
	 * Relational operators
	 */
	@Override
	public Value lt(Value val) {
		return this;
	}

	@Override
	public Value ltInt(IntValue val) {
		return this;
	}

	@Override
	public Value leq(Value val) {
		return this;
	}

	@Override
	public Value leqInt(IntValue val) {
		return this;
	}

	@Override
	public Value eq(Value val) {
		return this;
	}

	@Override
	public Value eqInt(IntValue val) {
		return this;
	}

	@Override
	public Value eqBool(BoolValue val) {
		return this;
	}

	@Override
	public Value eqStr(StrValue val) {
		return this;
	}

	@Override
	public Value neq(Value val) {
		return this;
	}

	@Override
	public Value neqInt(IntValue val) {
		return this;
	}

	@Override
	public Value neqBool(BoolValue val) {
		return this;
	}

	@Override
	public Value neqStr(StrValue val) {
		return this;
	}

	@Override
	public Value geq(Value val) {
		return this;
	}

	@Override
	public Value geqInt(IntValue val) {
		return this;
	}

	@Override
	public Value gt(Value val) {
		return this;
	}

	@Override
	public Value gtInt(IntValue val) {
		return this;
	}

	/*
	 * Boolean operators
	 */
	@Override
	public Value not() {
		return this;
	}

	@Override
	public Value and(Value val) {
		return this;
	}

	@Override
	public Value or(Value val) {
		return this;
	}

}
