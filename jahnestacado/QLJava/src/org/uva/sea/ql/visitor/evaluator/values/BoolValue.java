package org.uva.sea.ql.visitor.evaluator.values;

public class BoolValue extends Value {

	private final boolean value;

	public BoolValue(boolean value) {
		this.value = value;
	}

	public Boolean getValue() {
		return value;
	}
	
	@Override
	public boolean isBoolValue(){
		return true;
	}

	
}
