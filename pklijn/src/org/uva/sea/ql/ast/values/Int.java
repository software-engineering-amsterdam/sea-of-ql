package org.uva.sea.ql.ast.values;

public class Int extends Value {
	
	private final Integer value;
	
	public Int(int value) {
		this.value = value;
	}
	
	public Integer getValue() {
		return value;
	}
}
