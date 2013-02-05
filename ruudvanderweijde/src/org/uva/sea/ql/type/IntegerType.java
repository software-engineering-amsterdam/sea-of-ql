package org.uva.sea.ql.type;

public class IntegerType extends NumericType {
	
	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToIntegerType();
	}

	@Override
	public String toString() {
		return "IntegerType";
	}
}
