package org.uva.sea.ql.ast.types;

public class IntType extends Type {
private final String iType;
	
	public IntType(String iType) {
		this.iType = iType;
	}
	
	public String getIType() {
		return iType;
	}
}