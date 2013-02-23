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
	public boolean isCompatibleToNumericType() {
		return true;
	}
	
	@Override
	public boolean isCompatibleToIntegerType() {
		return true;
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
		return new IntegerValue(Math.abs(getValue()));
	}
	
	@Override
	public Value neg() {
		return new IntegerValue(getValue()*(-1));
	}

	@Override
	public Value geq(Value arg) {
		return arg.geqInt(this);
	}
	
	@Override
	public Value gt(Value arg) {
		return arg.gtInt(this);
	}
	
	@Override
	public Value leq(Value arg) {
		return arg.leqInt(this);
	}
	
	@Override
	public Value lt(Value arg) {
		return arg.ltInt(this);
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
	
	@Override
	protected Value geqInt(IntegerValue arg) {
		return new BooleanValue(arg.getValue() >= getValue());
	}
	@Override
	protected Value gtInt(IntegerValue arg) {
		return new BooleanValue(arg.getValue() > getValue());
	}
	@Override
	protected Value leqInt(IntegerValue arg) {
		return new BooleanValue(arg.getValue() <= getValue());
	}
	@Override
	protected Value ltInt(IntegerValue arg) {
		return new BooleanValue(arg.getValue() < getValue());
	}
}
