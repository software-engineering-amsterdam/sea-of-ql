package org.uva.sea.ql.ast.types;

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
