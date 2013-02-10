package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.literals.Result;


public class ErrorType extends Type {

	public ErrorType() {
		super("error");
	}

	@Override
	public boolean isCompatibleTo(Type t) {
		return true;
	}

	@Override
	public Result getTypeContainer() {
		return null;
	}
}
