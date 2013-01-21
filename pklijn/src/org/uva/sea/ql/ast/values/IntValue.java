package org.uva.sea.ql.ast.values;

public class IntValue extends Value {
	
	private final Integer value;
	
	public IntValue(int value) {
		this.value = value;
	}
	
	public Integer getValue() {
		return value;
	}
}
