package org.uva.sea.ql.ast.types;

public class TypeInt extends Type {
	
	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToTypeInt();
	}
	
	@Override
	public boolean isCompatibleToTypeInt() {
		return true;
	}
	
}
