package org.uva.sea.ql.ast.types;

public class StringType extends Type {
	private final String sType;
	
	public StringType(String sType) {
		this.sType = sType;
	}
	
	public String getSType() {
		return sType;
	}
}