package org.uva.sea.ql.ast.values;

public class StringValue extends Value {

	private final String value;
	
	public StringValue() {
		this("");
	}
	
	public StringValue(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj.getClass() != getClass())
			return false;
		if (obj == this)
			return true;
		
		return ((StringValue)obj).getValue().equals(getValue());
	}
}
