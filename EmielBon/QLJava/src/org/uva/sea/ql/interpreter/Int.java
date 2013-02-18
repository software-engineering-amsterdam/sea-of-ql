package org.uva.sea.ql.interpreter;

public class Int extends Value {

	private final int value;
	
	public Int(int value) {
		this.value = value;
	}

	public int getValue() {
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
	
	public Value pos(Value arg) {
		return new Int(getValue());
	}
	
	public Value neg(Value arg) {
		return new Int(-getValue());
	}
	
	public Value sub(Value arg) {
		return arg.subInt(this);
	}
	
	protected Value addInt(Int arg) {
		return new Int(arg.getValue() + getValue());
	}
	
	protected Value divInt(Int arg) {
		return new Int(arg.getValue() / getValue());
	}
	
	protected Value mulInt(Int arg) {
		return new Int(arg.getValue() * getValue());
	}
	
	protected Value subInt(Int arg) {
		return new Int(arg.getValue() - getValue());
	}
	
}