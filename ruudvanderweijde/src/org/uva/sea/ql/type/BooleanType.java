package org.uva.sea.ql.type;

import org.uva.sea.ql.value.Value;

public class BooleanType extends Type {

	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToBooleanType();
	}
	
	@Override
	public boolean isCompatibleTo(Value v) {
		return v.isCompatibleToBooleanType();
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