package org.uva.sea.ql.value;

public class StringValue extends Value {
	private final String value;
	
	public StringValue(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	@Override
	public boolean isCompatibleToIntegerType() { 
		return true; 
	}

	@Override
	public boolean isCompatibleToNumericType() {
		return true;
	}

	@Override
	public boolean isCompatibleToStringType() {
		return true;
	}

	@Override
	public boolean isCompatibleToBooleanType() {
		return true;
	}
}
