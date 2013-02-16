package org.uva.sea.ql.runtime;

public class StringValue extends Value {

	private String value; 
	
	public StringValue(String value) {
		this.value = value;
	}
	@Override
	public String getValue() {
		return value;
	}

}
