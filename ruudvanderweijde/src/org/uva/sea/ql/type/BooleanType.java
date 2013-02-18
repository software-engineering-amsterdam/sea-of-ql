package org.uva.sea.ql.type;

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

	@Override
	public boolean validate(String value) {
		if (value.equals("true") || value.equals("false")) {
			return true;
		}
		return false;
	}


}
