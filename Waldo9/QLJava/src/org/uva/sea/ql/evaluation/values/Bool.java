package org.uva.sea.ql.evaluation.values;

public class Bool extends Value {
	
	private final boolean value;
	
	public Bool(boolean value) {
		this.value = value;
	}
	
	public Boolean getValue() {
		return value;
	}

}
