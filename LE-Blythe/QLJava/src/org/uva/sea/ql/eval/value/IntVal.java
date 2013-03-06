package org.uva.sea.ql.eval.value;


public class IntVal extends Value {

	private int value;
	
	public IntVal(int n){
		value = n;
	}
	
	
	public Integer getValue(){
		return value;
	}
	
	@Override
	public String toString(){
		return Integer.toString(value);
	}
	
	//----------- Generic Numeric -------------------------
	@Override
	public Value add(Value arg) {
		return arg.addInt(this);
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
	public Value sub(Value arg) {
		return arg.subInt(this);
	}

	@Override
	public Value pos() {
		return new IntVal(Math.abs(this.getValue()));
	}

	@Override
	public Value neg() {
		return new IntVal(-1* this.getValue());
	}

	//----------- Generic Comparative-------------------------
	@Override
	public Value eq(Value arg) {
		return arg.eqInt(this);
	}

	@Override
	public Value gEq(Value arg) {
		return arg.gEqInt(this);
	}

	@Override
	public Value gt(Value arg) {
		return arg.gtInt(this);
	}

	@Override
	public Value lEq(Value arg) {
		return arg.lEqInt(this);
	}

	@Override
	public Value lt(Value arg) {
		return arg.ltInt(this);
	}

	@Override
	public Value nEq(Value arg) {
		return arg.nEqInt(this);
	}
	
	//----------- Int Numeric-------------------------
	@Override
	protected Value addInt(IntVal arg) {
		return new IntVal(arg.getValue() + this.getValue());
	}

	@Override
	protected Value divInt(IntVal arg) {
		return new IntVal(arg.getValue() / this.getValue());
	}

	@Override
	protected Value mulInt(IntVal arg) {
		return new IntVal(arg.getValue() * this.getValue());
	}

	@Override
	protected Value subInt(IntVal arg) {
		return new IntVal(arg.getValue() - this.getValue());
	}
	
	//----------- Int Comparative -------------------------
	@Override
	protected Value eqInt(IntVal arg) {
		return new BoolVal(arg.getValue() == this.getValue());
	}
	
	@Override
	protected Value nEqInt(IntVal arg) {
		return new BoolVal(arg.getValue() != this.getValue());
	}
	
	@Override
	protected Value gEqInt(IntVal arg) {
		return new BoolVal(arg.getValue() >= this.getValue());
	}
	
	@Override
	protected Value gtInt(IntVal arg) {
		return new BoolVal(arg.getValue() > this.getValue());
	}
	
	@Override
	protected Value lEqInt(IntVal arg) {
		return new BoolVal(arg.getValue() <= this.getValue());
	}
	
	@Override
	protected Value ltInt(IntVal arg) {
		return new BoolVal(arg.getValue() < this.getValue());
	}
	
}
