package org.uva.sea.ql.interpreter;

public class StringValue extends Value {

	private final String value;
	
	public StringValue(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public boolean equals(Object other) {
		if (other instanceof StringValue) {
			String x = getValue();
			String y = ((StringValue)other).getValue();
			return x.equals(y);
		}
		return false;
	}
	
	public String toString() {
		return getValue().toString();
	}
	
}