package org.uva.sea.ql.ast.types;

public class StringType extends Type {

	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToString();
	}
	
	@Override
	public boolean isCompatibleToString() {
		return true;
	}

}
