package org.uva.sea.ql.ast.types;


public class ErrorType extends TypeDescription {

	public ErrorType() {
		super("error");
	}

	@Override
	public boolean isCompatibleTo(TypeDescription t) {
		return true;
	}
}
