package org.uva.sea.ql.evaluator.values;

public class IntValue extends AValue {
	private final Integer value;
	
	public IntValue(Integer value) {
		this.value = value;
	}
	
	public Integer getValue() {
		return value;
	}
	
	
	@Override
	public AValue pos() {
		return new IntValue(this.getValue());
	}
	
	@Override
	public AValue neg() {
		return new IntValue(-this.getValue());
	}
	
	@Override
	public AValue add(AValue arg) {
		return arg.addInt(this);
	}
	
	@Override
	public AValue sub(AValue arg) {
		return arg.subInt(this);
	}
	
	@Override
	public AValue mul(AValue arg) {
		return arg.mulInt(this);
	}
	
	@Override
	public AValue div(AValue arg) {
		return arg.divInt(this);
	}
	
	@Override
	public AValue eq(AValue arg) {
		return arg.eqInt(this);
	}
	
	@Override
	public AValue neq(AValue arg) {
		return arg.neqInt(this);
	}
	
	@Override
	public AValue gt(AValue arg) {
		return arg.gtInt(this);
	}
	
	@Override
	public AValue geq(AValue arg) {
		return arg.geqInt(this);
	}
	
	@Override
	public AValue lt(AValue arg) {
		return arg.ltInt(this);
	}
	
	@Override
	public AValue leq(AValue arg) {
		return arg.leqInt(this);
	}
	
	
	
	@Override
	protected AValue addInt(IntValue arg) {
		return new IntValue(arg.getValue() + this.getValue());
	}
	
	@Override
	protected AValue subInt(IntValue arg) {
		return new IntValue(arg.getValue() - this.getValue());
	}
	
	@Override
	protected AValue mulInt(IntValue arg) {
		return new IntValue(arg.getValue() * this.getValue());
	}
	
	@Override
	protected AValue divInt(IntValue arg) {
		return new IntValue(arg.getValue() / this.getValue());
	}
	
	@Override
	protected AValue eqInt(IntValue arg) {
		return new BoolValue(arg.getValue() == this.getValue());
	}
	
	@Override
	protected AValue neqInt(IntValue arg) {
		return new BoolValue(arg.getValue() != this.getValue());
	}
	
	@Override
	protected AValue gtInt(IntValue arg) {
		return new BoolValue(arg.getValue() > this.getValue());
	}
	
	@Override
	protected AValue geqInt(IntValue arg) {
		return new BoolValue(arg.getValue() >= this.getValue());
	}
	
	@Override
	protected AValue ltInt(IntValue arg) {
		return new BoolValue(arg.getValue() < this.getValue());
	}
	
	@Override
	protected AValue leqInt(IntValue arg) {
		return new BoolValue(arg.getValue() <= this.getValue());
	}
}