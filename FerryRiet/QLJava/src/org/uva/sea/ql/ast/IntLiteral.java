package org.uva.sea.ql.ast;

public class IntLiteral extends Expr {

	private final int value;

	public IntLiteral(int n) {
		this.value = n;
	}

	public int getValue() {
		return value;
	}
}
