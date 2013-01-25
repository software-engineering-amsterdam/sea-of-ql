package org.uva.sea.ql.ast.types;

public class ErrorType extends Type{
	
	public boolean isCompatibleTo(Type t) {
		return true;
	}

}
