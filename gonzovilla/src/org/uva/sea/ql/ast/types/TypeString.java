package org.uva.sea.ql.ast.types;

public class TypeString extends Type {

	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToTypeString();
	}
	
	@Override
	public boolean isCompatibleToTypeString() {
		return true;
	}
	
}
