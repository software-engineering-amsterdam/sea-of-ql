package org.uva.sea.ql.visitor.evaluator.values;

public class StrValue extends Value {
	private final String value;

	public StrValue(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
	@Override
	public boolean isStrValue(){
		return true;
	}

}
