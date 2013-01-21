package org.uva.sea.ql.ast.type;

public class BoolType extends Type{

	private final boolean value;
	
	public BoolType(boolean value){
		this.value = value; 
	}

	public boolean getValue(){
		return value;
	}
}
