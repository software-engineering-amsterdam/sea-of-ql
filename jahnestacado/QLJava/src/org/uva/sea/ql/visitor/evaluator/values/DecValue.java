package org.uva.sea.ql.visitor.evaluator.values;

public class DecValue extends Value {
	private final float value;

	public DecValue(float value) {
		this.value = value;
	}

	public Float getValue() {
		return value;
	}
	
	
	@Override
	public boolean isDecValue(){
		return true;
	}


}
