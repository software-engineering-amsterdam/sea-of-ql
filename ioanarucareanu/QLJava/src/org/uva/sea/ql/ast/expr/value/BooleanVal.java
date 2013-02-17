package org.uva.sea.ql.ast.expr.value;

public class BooleanVal extends Val {
	
	private boolean value;
	
	public BooleanVal() {
		
	}
	
	public BooleanVal(boolean value) {
		this.value = value;
	}

	public BooleanVal(BooleanVal val) {
		this.value = val.getValue();
	}

	public boolean getValue() {
		return value;
	}

	public void setValue(boolean value) {
		this.value = value;
	}
	
	public BooleanVal and(BooleanVal bool) {
		return new BooleanVal(getValue() && bool.getValue());
	}

	public BooleanVal or(BooleanVal bool) {
		return new BooleanVal(getValue() || bool.getValue());
	}

	public BooleanVal not() {
		return new BooleanVal(!getValue());
	}
	
	public BooleanVal equalTo(BooleanVal value) {
		return new BooleanVal(getValue() == value.getValue());
	}
	
	public BooleanVal notEqualTo(BooleanVal value) {
		return equalTo(value).not();
	}

	@Override
	public String toString() {
		return "BooleanVal [value=" + value + "]";
	}

}
