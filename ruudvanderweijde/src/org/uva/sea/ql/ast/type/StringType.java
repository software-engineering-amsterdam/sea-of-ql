package org.uva.sea.ql.ast.type;

public class StringType extends Type {
	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToStringType();
	}
	
	@Override
	public boolean isCompatibleToStringType() {
		return true;
	}
}
