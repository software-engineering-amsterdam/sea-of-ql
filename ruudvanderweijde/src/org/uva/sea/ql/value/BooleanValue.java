package org.uva.sea.ql.value;

public class BooleanValue extends Value {
	private final Boolean value;
	
	public BooleanValue(Boolean value) {
		this.value = value;
	}

	public Boolean getValue() {
		return value;
	}

}
