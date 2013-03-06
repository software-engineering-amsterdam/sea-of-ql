package org.uva.sea.ql.parser.evaluator.result;

import org.uva.sea.ql.parser.evaluator.result.visitor.ValueVisitor;

public class BoolValue extends Value {
	private final boolean value;

	public BoolValue(boolean value) {
		this.value = value;
	}

	@Override
	public Boolean getValue() {
		return value;
	}

	@Override
	public <T> T accept(ValueVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof BoolValue)) {
			return false;
		}
		
		return getValue().equals(((BoolValue)obj).getValue());
	}

	/*
	 * Relational operators
	 */

	@Override
	public Value eq(Value val) {
		return val.eqBool(this);
	}

	@Override
	public Value eqBool(BoolValue value) {
		return new BoolValue(this.equals(value));
	}

	@Override
	public Value neq(Value val) {
		return val.neqBool(this);
	}

	@Override
	public Value neqBool(BoolValue value) {
		return new BoolValue(!this.equals(value));
	}

	/*
	 * Boolean operators
	 */
	@Override
	public Value not() {
		return new BoolValue(!getValue());
	}

	@Override
	public Value and(Value val) {
		return val.andBool(this);
	}

	@Override
	public Value andBool(BoolValue val) {
		return new BoolValue(val.getValue() && getValue());
	}

	@Override
	public Value or(Value val) {
		return val.orBool(this);
	}

	@Override
	public Value orBool(BoolValue val) {
		return new BoolValue(val.getValue() || getValue());
	}
}
