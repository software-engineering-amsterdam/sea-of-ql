package org.uva.sea.ql.ast.values;

public class BoolValue extends Value {
	
	private final boolean value;
	
	public BoolValue(boolean value) {
		this.value = value;
	}
	
	public boolean getValue() {
		return value;
	}
}
