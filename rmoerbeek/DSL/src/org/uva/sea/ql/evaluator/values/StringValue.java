package org.uva.sea.ql.evaluator.values;

public class StringValue extends Value {
	
	private final String value;
	
	public StringValue(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
	
	// Double Dispatch
	
	@Override
	public Value eq(Value arg) {
		return arg.eqString(this);
	}
	
	@Override
	public Value neq(Value arg) {
		return arg.neqString(this);
	}
	
	// Computations
	
	@Override 
	protected Value eqString(StringValue arg) {
		return new BoolValue(this.getValue() == arg.getValue());
	}
	
	@Override 
	protected Value neqString(StringValue arg) {
		return new BoolValue(this.getValue() != arg.getValue());
	}

}
