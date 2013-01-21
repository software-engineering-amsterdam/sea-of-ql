package org.uva.sea.ql.types;

public class BoolType extends Type {
	private final String bType;
	
	public BoolType(String bType) {
		this.bType = bType;
	}
	
	public String getBType() {
		return bType;
	}
}