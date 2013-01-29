package org.uva.sea.ql.ast.types;

public class BoolType extends Type {
	private final String bType;
	
	public BoolType() {
		this.bType = "boolean";
	}
	
	public String getBType() {
		return bType;
	}
}