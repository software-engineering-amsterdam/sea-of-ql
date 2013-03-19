package org.uva.sea.ql.evaluator.values;

public class IntValue extends Value {
	
	private final Integer value;
	
	public IntValue(Integer value) {
		this.value = value;
	}
	
	public Integer getValue() {
		return this.value;
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
	public Value gt(Value arg) {
		return arg.gtInt(this);
	}
	
	@Override
	public Value lt(Value arg) {
		return arg.ltInt(this);
	}
	
	@Override
	public Value geq(Value arg) {
		return arg.geqInt(this);
	}
	
	@Override
	public Value leq(Value arg) {
		return arg.leqInt(this);
	}
	
	@Override
	public Value eq(Value arg) {
		return arg.eqInt(this);
	}
	
	@Override
	public Value neq(Value arg) {
		return arg.neqInt(this);
	}
	
	@Override
	public Value pos() {
		return this.posInt();
	}
	
	@Override
	public Value neg() {
		return this.negInt();
	}
	
	
	
	// Computations

	@Override 
	protected Value addInt(IntValue arg) {
		return new IntValue(arg.getValue() + this.getValue());
	}
	
	@Override 
	protected Value mulInt(IntValue arg) {
		return new IntValue(arg.getValue() * this.getValue());
	}
	
	@Override 
	protected Value divInt(IntValue arg) {
		return new IntValue(arg.getValue() / this.getValue());
	}
	
	@Override 
	protected Value subInt(IntValue arg) {
		return new IntValue(arg.getValue() - this.getValue());
	}
	
	@Override 
	protected Value gtInt(IntValue arg) {
		return new BoolValue(arg.getValue() > this.getValue());
	}
	
	@Override 
	protected Value ltInt(IntValue arg) {
		return new BoolValue(arg.getValue() < this.getValue());
	}
	
	@Override 
	protected Value geqInt(IntValue arg) {
		return new BoolValue(arg.getValue() >= this.getValue());
	}
	
	@Override 
	protected Value neqInt(IntValue arg) {
		return new BoolValue(arg.getValue() != this.getValue());
	}
	
	@Override 
	protected Value eqInt(IntValue arg) {
		return new BoolValue(arg.getValue() == this.getValue());
	}
	
	@Override 
	protected Value leqInt(IntValue arg) {
		return new BoolValue(arg.getValue() <= this.getValue());
	}
	
	@Override
	protected Value posInt() {
		return new BoolValue(this.getValue() < 0); // zero is considered positive
	}
	
	@Override
	protected Value negInt() {
		return new BoolValue(this.getValue() >= 0);
	}
	
	
}
