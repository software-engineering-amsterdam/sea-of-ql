package org.uva.sea.ql.ast.types;

public class StringType extends Type {
	private final String sType;
	
	public StringType() {
		this.sType = "string";
	}
	
	public String getSType() {
		return sType;
	}
}