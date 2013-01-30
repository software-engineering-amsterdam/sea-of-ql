package org.uva.sea.ql.ast.types;

public class NumericType extends Type {

	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToNumeric();
	}
	
	@Override
	public boolean isCompatibleToNumeric() {
		return true;
	}
	
	@Override
	public boolean isCompatibleToInt() {
		return true;
	}

}
