package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.Type;

public class ErrorType extends Type {

	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToError();
	}

	@Override
	public boolean isCompatibleToError() {
		return true;
	}

}
