package org.uva.sea.ql.parser.evaluator.result;

import org.uva.sea.ql.parser.evaluator.result.visitor.ValueVisitor;

public class StrValue extends Value {
	private final String value;

	public StrValue(String value) {
		this.value = new String(value);
	}

	@Override
	public String getValue() {
		return value;
	}

	@Override
	public <T> T accept(ValueVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public boolean equals(Object obj) {
		boolean equal;

		if (obj instanceof StrValue) {
			equal = equals((StrValue) obj);
			// TODO: add test for instanceof Value, and throw exception maybe?
			// or should I do it with overloaded methods in the Value class
			// which then throw an UnsupportedOperationException?
		} else {
			equal = super.equals(obj);
		}

		return equal;
	}

	public boolean equals(StrValue value) {
		return getValue().equals(value.getValue());
	}

	/*
	 * Adding
	 */
	@Override
	public Value add(Value val) {
		return val.addStr(this);
	}

	@Override
	public Value addStr(StrValue val) {
		return new StrValue(val.getValue() + this.getValue());
	}

	/*
	 * Relational
	 */
	@Override
	public Value eq(Value val) {
		return val.eqStr(this);
	}

	@Override
	public Value eqStr(StrValue value) {
		return new BoolValue(this.equals(value));
	}

	@Override
	public Value neq(Value val) {
		return val.neqStr(this);
	}

	@Override
	public Value neqStr(StrValue value) {
		return new BoolValue(!this.equals(value));
	}

}
