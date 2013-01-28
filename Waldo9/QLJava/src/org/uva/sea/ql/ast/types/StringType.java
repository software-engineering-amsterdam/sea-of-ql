package org.uva.sea.ql.ast.types;


public class StringType extends Type {

	@Override
	public boolean isCompatibleTo(Type type) {
		return type.isCompatibleToString();
	}
	
	@Override
	public boolean isCompatibleToString() {
		return true;
	}
}
