package org.uva.sea.ql.ast.type;

public class UndefinedType extends Type {

	public boolean isCompatibleWith(Type t) {
		return false;
	}
	
}
