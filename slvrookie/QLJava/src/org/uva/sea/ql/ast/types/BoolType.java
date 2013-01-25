package org.uva.sea.ql.ast.types;

public class BoolType extends Type {
	
	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToBoolType();
	}
	@Override
	public boolean isCompatibleToBoolType() {
		return true;
	}

}
