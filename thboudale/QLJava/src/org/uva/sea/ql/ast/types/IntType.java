package org.uva.sea.ql.ast.types;

public class IntType extends Type {
private final String iType;
	
	public IntType() {
		this.iType = "int";
	}
	
	public String getIType() {
		return iType;
	}
}