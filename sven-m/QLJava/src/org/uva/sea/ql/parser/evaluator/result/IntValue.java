package org.uva.sea.ql.parser.evaluator.result;

public class IntValue extends Value {
	private final int value;
	
	public IntValue(int value) {
		this.value = value;
	}
	
	public int getIntValue() {
		return value;
	}
	
	public <T> T accept(ValueVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
	/*
	 * Arithmetic
	 */
	@Override
	public Value add(Value val) {
		return val.addInt(this);
	}
	
	@Override
	public Value addInt(IntValue val) {
		return new IntValue(val.getIntValue() + this.getIntValue());
	}
	
	@Override
	public Value sub(Value val) {
		return val.subInt(this);
	}
	
	@Override
	public Value subInt(IntValue val) {
		return new IntValue(val.getIntValue() - this.getIntValue());
	}
	
	@Override
	public Value mul(Value val) {
		return val.mulInt(this);
	}
	
	@Override
	public Value mulInt(IntValue val) {
		return new IntValue(val.getIntValue() * this.getIntValue());
	}
	
	@Override
	public Value div(Value val) {
		return val.divInt(this);
	}
	
	@Override
	public Value divInt(IntValue val) {
		return new IntValue(val.getIntValue() / this.getIntValue());
	}
	
	@Override
	public Value pos() {
		return this;
	}
	
	@Override
	public Value neg() {
		return new IntValue(-getIntValue());
	}
	
	
	/*
	 * Relational operators
	 */
	@Override
	public Value lt(Value val) {
		return val.ltInt(this);
	}
	
	@Override
	public Value ltInt(IntValue val) {
		return new BoolValue(val.getIntValue() < this.getIntValue());
	}
	
	@Override
	public Value leq(Value val) {
		return val.leqInt(this);
	}
	
	@Override
	public Value leqInt(IntValue val) {
		return new BoolValue(val.getIntValue() <= this.getIntValue());
	}
	
	@Override
	public Value eq(Value val) {
		return val.eqInt(this);
	}
	
	@Override
	public Value eqInt(IntValue val) {
		return new BoolValue(val.getIntValue() == this.getIntValue());
	}
	
	@Override
	public Value neq(Value val) {
		return val.neqInt(this);
	}
	
	@Override
	public Value neqInt(IntValue val) {
		return new BoolValue(val.getIntValue() != this.getIntValue());
	}
	
	@Override
	public Value geq(Value val) {
		return val.geqInt(this);
	}
	
	@Override
	public Value geqInt(IntValue val) {
		return new BoolValue(val.getIntValue() >= this.getIntValue());
	}
	
	@Override
	public Value gt(Value val) {
		return val.gtInt(this);
	}
	
	@Override
	public Value gtInt(IntValue val) {
		return new BoolValue(val.getIntValue() > this.getIntValue());
	}
	
}
