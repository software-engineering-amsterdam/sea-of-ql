package org.uva.sea.ql.value;



public class IntegerValue extends Value {
	private final Integer value;
	
	public IntegerValue(Integer value) {
		this.value = value;
	}
	
	public Integer getValue() {
		return value;
	}

	@Override
	public Value add(Value arg) {
		return arg.addInt(this);
	}
	
	@Override
	public Value sub(Value arg) {
		return arg.subInt(this);
	}
	
	@Override
	public Value div(Value arg) {
		return arg.divInt(this);
	}
	
	@Override
	public Value mul(Value arg) {
		return arg.mulInt(this);
	}
	
	@Override
	public Value pos() {
		return new IntegerValue(Math.abs(this.getValue()));
	}
	
	@Override
	public Value neg() {
		return new IntegerValue(this.getValue()*-1);
	}

	/*
	 * Values are reversed because of double dispatch
	 */
	@Override
	protected Value addInt(IntegerValue arg) {
		return new IntegerValue(arg.getValue() + getValue());
	}

	@Override
	protected Value subInt(IntegerValue arg) {
		return new IntegerValue(arg.getValue() - getValue());
	}
	
	@Override
	protected Value divInt(IntegerValue arg) {
		return new IntegerValue(arg.getValue() / getValue());
	}
	@Override
	protected Value mulInt(IntegerValue arg) {
		return new IntegerValue(arg.getValue() * getValue());
	}
}
