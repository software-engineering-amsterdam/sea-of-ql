package org.uva.sea.ql.ast.type;

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
