package org.uva.sea.ql.ast.types;

public class TypeError extends Type {

	@Override
	public boolean isCompatibleTo(Type t) {
		return false;
	}

}
