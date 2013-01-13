package org.uva.sea.ql.type;

public class Bool extends ValueType {
	private final boolean value;
	
	public Bool( boolean value ) {
		this.value = value;
	}
	
	public boolean getValue() {
		return this.value;
	}
}
