package org.uva.sea.ql.ast.type;


public class Undefined extends Type {

	@Override
	public boolean isCompatibleTo(Type t) {
		return false;
	}

}
