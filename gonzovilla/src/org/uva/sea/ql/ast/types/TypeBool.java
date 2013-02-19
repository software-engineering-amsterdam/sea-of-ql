package org.uva.sea.ql.ast.types;

public class TypeBool extends Type {

	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToTypeBool();
	}
	
	@Override
	public boolean isCompatibleToTypeBool() {
		return true;
	}

}