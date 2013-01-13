package org.uva.sea.ql.type;

public class Text extends ValueType {
	private final String value;
	
	public Text( String value ) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
}
