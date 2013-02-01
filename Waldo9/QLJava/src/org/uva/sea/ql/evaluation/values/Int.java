package org.uva.sea.ql.evaluation.values;

public class Int extends Value {
	
	private final int value;
	
	public Int(int value) {
		this.value = value;
	}
	
	public Integer getValue() {
		return value;
	}

}
