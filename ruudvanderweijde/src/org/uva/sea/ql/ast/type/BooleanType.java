package org.uva.sea.ql.ast.type;

public class BooleanType extends Type {

	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToBooleanType();
	}
	
	@Override
	public boolean isCompatibleToBooleanType() {
		return true;
	}	

	@Override
	public String toString() {
		return "BooleanType";
	}


}
