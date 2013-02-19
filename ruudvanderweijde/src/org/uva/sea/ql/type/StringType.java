package org.uva.sea.ql.type;

import org.uva.sea.ql.value.Value;

public class StringType extends Type {
	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToStringType();
	}

	@Override
	public boolean isCompatibleTo(Value v) {
		// String type can contain any value. 
		return v.isCompatibleToStringType()
				|| v.isCompatibleToBooleanType()
				|| v.isCompatibleToNumericType() 
				|| v.isCompatibleToNumericType();
	}

	@Override
	public boolean isCompatibleToStringType() {
		return true;
	}

	@Override
	public String toString() {
		return "StringType";
	}
}