package org.uva.sea.ql.ast.types;

public class ErrorType extends AType {
	
	@Override
	public  boolean isCompatibleTo(AType t) {
		return false;
	}
}