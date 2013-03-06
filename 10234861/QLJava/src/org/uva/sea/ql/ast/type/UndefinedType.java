package org.uva.sea.ql.ast.type;

public class UndefinedType extends Type {

	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToUndefined();
	}

	@Override
	public boolean isCompatibleToUndefined() {
		return true;
	}

}