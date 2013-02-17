package org.uva.sea.ql.interpreter;

public class StringVal extends Value{

	private final String value;
	
	public StringVal(String value){
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return value;
	}
}
