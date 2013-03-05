package org.uva.sea.ql.gen;

import org.uva.sea.ql.ast.types.Type;

public class TypeError extends Type {
	private final String typeErrorMessage;

	public TypeError(String typeErrorMessage) {
		this.typeErrorMessage = typeErrorMessage;
	}

	public String getTypeErrorMessage() {
		return typeErrorMessage;
	}

	@Override
	public boolean isCompatibleTo(Type t) {
		return false;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return typeErrorMessage;
	}

}
