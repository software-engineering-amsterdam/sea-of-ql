package org.uva.sea.ql.ast.expr.value;

public class BooleanValue extends Value<Boolean> {

	public BooleanValue() {
		super(false);
	}
	
	public BooleanValue(Boolean value) {
		super(value);
	}
	
	public BooleanValue(BooleanValue value) {
		this(value.getValue());
	}

	public BooleanValue and(BooleanValue bool) {
		return new BooleanValue(getValue() && bool.getValue());
	}
	
	public BooleanValue or(BooleanValue bool) {
		return new BooleanValue(getValue() || bool.getValue());
	}
	
	public BooleanValue not() {
		return new BooleanValue(!getValue());
	}
}
