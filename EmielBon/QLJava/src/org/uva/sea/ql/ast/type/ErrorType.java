package org.uva.sea.ql.ast.type;

public class ErrorType extends Type {

	public boolean isCompatibleWith(Type t) {
		return false;
	}
	
}
