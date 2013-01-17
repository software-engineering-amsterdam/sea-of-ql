package org.uva.sea.ql.ast.expr.value;

public class BoolLiteral extends Value {

	private final boolean value;

	public BoolLiteral(boolean value) {
		this.value = value;
	}

	public boolean getValue() {
		return value;
	}
	
}
