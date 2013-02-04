package org.uva.sea.ql.visitor.eval.value;

public class Bool extends AbstractValue {

	private final boolean value;

	public Bool(boolean value) {
		this.value = value;
	}

	public boolean getValue() {
		return this.value;
	}

	@Override
	public AbstractValue not() {
		return new Bool(!this.getValue());
	}

	@Override
	public AbstractValue and(AbstractValue value) {
		return value.andBool(this);
	}

	@Override
	protected AbstractValue andBool(Bool value) {
		return new Bool(value.getValue() && this.getValue());
	}

	@Override
	public AbstractValue or(AbstractValue value) {
		return value.orBool(this);
	}

	@Override
	protected AbstractValue orBool(Bool value) {
		return new Bool(value.getValue() || this.getValue());
	}

	@Override
	public AbstractValue eq(AbstractValue value) {
		return value.eqBool(this);
	}

	@Override
	public AbstractValue eqBool(Bool value) {
		return new Bool(value.getValue() == this.getValue());
	}

	@Override
	public AbstractValue neq(AbstractValue value) {
		return value.neqBool(this);
	}

	@Override
	public AbstractValue neqBool(Bool value) {
		return new Bool(value.getValue() != this.getValue());
	}

}
