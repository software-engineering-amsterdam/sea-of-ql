package org.uva.sea.ql.eval;

public class IntegerValue extends Value {

	private final Integer value;
	
	public IntegerValue(Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}
	
	public Value add(Value arg) {
		return arg.addInt(this);
	}
	
	public Value div(Value arg) {
		return arg.divInt(this);
	}
	
	public Value mul(Value arg) {
		return arg.mulInt(this);
	}
	
	public Value pos() {
		return new IntegerValue(getValue());
	}
	
	public Value neg() {
		return new IntegerValue(-getValue());
	}
	
	public Value sub(Value arg) {
		return arg.subInt(this);
	}
	
	public Value eq(Value arg) {
		return arg.eqInt(this);
	}
	
	public Value geq(Value arg) {
		return arg.geqInt(this);
	}
	
	public Value gt(Value arg) {
		return arg.gtInt(this);
	}
	
	public Value leq(Value arg) {
		return arg.leqInt(this);
	}
	
	public Value lt(Value arg) {
		return arg.ltInt(this);
	}
	
	public Value neq(Value arg) {
		return arg.neqInt(this);
	}
	
	protected Value addInt(IntegerValue arg) {
		return new IntegerValue(arg.getValue() + getValue());
	}
	
	protected Value divInt(IntegerValue arg) {
		return new IntegerValue(arg.getValue() / getValue());
	}
	
	protected Value mulInt(IntegerValue arg) {
		return new IntegerValue(arg.getValue() * getValue());
	}
	
	protected Value subInt(IntegerValue arg) {
		return new IntegerValue(arg.getValue() - getValue());
	}
	
	protected Value eqInt(IntegerValue arg) {
		return new BooleanValue(arg.getValue() == getValue());
	}
	
	protected Value geqInt(IntegerValue arg) {
		return new BooleanValue(arg.getValue() >= getValue());
	}
	
	protected Value gtInt(IntegerValue arg) {
		return new BooleanValue(arg.getValue() > getValue());
	}
	
	protected Value leqInt(IntegerValue arg) {
		return new BooleanValue(arg.getValue() <= getValue());
	}
	
	protected Value ltInt(IntegerValue arg) {
		return new BooleanValue(arg.getValue() < getValue());
	}
	
	protected Value neqInt(IntegerValue arg) {
		return new BooleanValue(arg.getValue() != getValue());
	}
	
	public boolean equals(Object other) {
		if (other instanceof IntegerValue) {
			Integer x = getValue();
			Integer y = ((IntegerValue)other).getValue();
			return x.equals(y);
		}
		return false;
	}
	
	public String toString() {
		return getValue().toString();
	}
	
}