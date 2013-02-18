package org.uva.sea.ql.type;

import org.uva.sea.ql.value.Value;

public class NumericType extends Type {

	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToNumericType();
	}

	@Override
	public boolean isCompatibleTo(Value v) {
		return v.isCompatibleToNumericType();
	}
	
	@Override
	public boolean isCompatibleToNumericType() {
		return true;
	}
	
	@Override
	public boolean isCompatibleToIntegerType() {
		return true;
	}
	
	@Override
	public String toString() {
		return "NumericType";
	}
}