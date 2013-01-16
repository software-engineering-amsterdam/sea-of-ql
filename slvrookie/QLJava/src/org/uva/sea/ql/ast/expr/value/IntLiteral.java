package org.uva.sea.ql.ast.expr.value;

public class IntLiteral extends Value {

	private final int value;

	public IntLiteral(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

}
