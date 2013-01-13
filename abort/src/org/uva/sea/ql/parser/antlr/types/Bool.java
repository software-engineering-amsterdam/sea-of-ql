package org.uva.sea.ql.parser.antlr.types;

public class Bool extends DataType {
	private boolean value; 
	
	public Bool() { }
	
	public Bool(boolean value) {
		this.value = value;
	}
	
	public Object getValue() {
		return value;
	}
}
