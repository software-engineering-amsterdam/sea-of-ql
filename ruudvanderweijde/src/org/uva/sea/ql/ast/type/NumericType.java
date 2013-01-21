package org.uva.sea.ql.ast.type;

public class NumericType extends Type {

	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToNumericType();
	}
	
	@Override
	public boolean isCompatibleToIntegerType() {
		return true;
	}
	
	@Override
	public boolean isCompatibleToNumericType() {
		return true;
	}

}
