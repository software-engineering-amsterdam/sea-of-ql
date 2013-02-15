package org.uva.sea.ql.ast.types;

public class NullType extends Type {
	@Override
	public boolean isCompatibleTo(Type t) {
		return false;
	}
}
