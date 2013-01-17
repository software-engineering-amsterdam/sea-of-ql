package org.uva.sea.ql.ast.type;

public class ReturnType extends Type{

	private final String type;
	
	public ReturnType(String type){
		this.type = type;
	}

	public String getType() {
		return type;
	}
	
}
