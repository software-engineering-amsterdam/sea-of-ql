package org.uva.sea.ql.ast.type;


public class UndefinedType extends Type {

	@Override
	public boolean isCompatibleTo(Type t) {
		return false;
	}

}
