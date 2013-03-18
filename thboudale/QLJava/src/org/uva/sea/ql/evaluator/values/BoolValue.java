package org.uva.sea.ql.evaluator.values;

public class BoolValue extends AValue {
	private final boolean value;
	
	public BoolValue(boolean value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return String.valueOf(value);
	}
	
	@Override
	public Boolean getValue() {
		return value;
	}
	
	@Override
	public AValue not() {
		return new BoolValue(!this.getValue());
	}
	
	@Override
	public AValue and(AValue arg) {
		return arg.andBool(this);
	}
	
	@Override
	public AValue or(AValue arg) {
		return arg.orBool(this);
	}
	
	@Override
	public AValue eq(AValue arg) {
		return arg.eqBool(this);
	}
	
	@Override
	public AValue neq(AValue arg) {
		return arg.neqBool(this);
	}
	
	
	
	@Override
	protected AValue andBool(BoolValue arg) {
		return new BoolValue(arg.getValue() && this.getValue());
	}
	
	@Override
	protected AValue orBool(BoolValue arg) {
		return new BoolValue(arg.getValue() || this.getValue());
	}
	
	@Override
	protected AValue eqBool(BoolValue arg) {
		return new BoolValue(arg.getValue() == this.getValue());
	}
	
	@Override
	protected AValue neqBool(BoolValue arg) {
		return new BoolValue(arg.getValue() != this.getValue());
	}
}