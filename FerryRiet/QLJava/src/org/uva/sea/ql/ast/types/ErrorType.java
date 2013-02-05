package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.operators.ExpressionResult;


public class ErrorType extends TypeDescription {

	public ErrorType() {
		super("error");
	}

	@Override
	public boolean isCompatibleTo(TypeDescription t) {
		return true;
	}

	@Override
	public ExpressionResult getTypeContainer() {
		return null;
	}
}
