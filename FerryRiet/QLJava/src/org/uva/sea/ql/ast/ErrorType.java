package org.uva.sea.ql.ast;

public class ErrorType extends TypeDescription {

	public ErrorType() {
		super("error");
	}

	@Override
	public boolean compatibleType(TypeDescription testType) {
		return true;
	}

}
