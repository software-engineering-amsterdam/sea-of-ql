package org.uva.sea.ql.ast.type;


public class UndefinedType extends Type {

	@Override
	public boolean isCompatibleTo(Type t) {
		return isCompatibleToBooleanType();
	}
	
	@Override
	public String toString() {
		return "UndefinedType";
	}
	
	
	@Override
	public boolean isCompatibleToBooleanType() {
		return true;
	}	

}
