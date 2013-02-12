package org.uva.sea.ql.type;

public class StringType extends Type {	
	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToStringType();
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
