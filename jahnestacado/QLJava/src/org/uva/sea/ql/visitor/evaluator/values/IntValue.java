package org.uva.sea.ql.visitor.evaluator.values;

public class IntValue extends Value {

	private final int value;

	public IntValue(int value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}
	
	@Override
	public boolean isIntValue(){
		return true;
	}

	

}
