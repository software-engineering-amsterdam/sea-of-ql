package org.uva.sea.ql.evaluation.values;

public class Int extends Value {

	private final Integer value;

	public Int(Integer value) {
		this.value = value;
	}

	@Override
	public Integer getValue() {
		return value;
	}

	// algebra

	@Override
	public Value add(Value arg) {
		return arg.addInt(this);
	}

	@Override
	protected Value addInt(Int arg) {
		return new Int(arg.getValue() + getValue());
	}

	@Override
	public Value sub(Value arg) {
		return arg.subInt(this);
	}

	@Override
	protected Value subInt(Int arg) {
		return new Int(arg.getValue() - getValue());
	}

	@Override
	public Value mul(Value arg) {
		return arg.mulInt(this);
	}

	@Override
	protected Value mulInt(Int arg) {
		return new Int(arg.getValue() * getValue());
	}

	@Override
	public Value div(Value arg) {
		return arg.divInt(this);
	}

	@Override
	protected Value divInt(Int arg) {
		return new Int(arg.getValue() / getValue());
	}

	@Override
	public Value neg() {
		return new Int(-getValue());
	}

	@Override
	public Value pos() {
		return new Int(+getValue());
	}

	// comparisons

	@Override
	public Value greater(Value arg) {
		return arg.greaterInt(this);
	}

	@Override
	protected Value greaterInt(Int arg) {
		return new Bool(arg.getValue() > getValue());
	}

	@Override
	public Value greaterOrEq(Value arg) {
		return arg.greaterOrEqInt(this);
	}

	@Override
	protected Value greaterOrEqInt(Int arg) {
		return new Bool(arg.getValue() >= getValue());
	}

	@Override
	public Value less(Value arg) {
		return arg.lessInt(this);
	}

	@Override
	protected Value lessInt(Int arg) {
		return new Bool(arg.getValue() < getValue());
	}

	@Override
	public Value lessOrEq(Value arg) {
		return arg.lessOrEqInt(this);
	}

	@Override
	protected Value lessOrEqInt(Int arg) {
		return new Bool(arg.getValue() <= getValue());
	}

}
