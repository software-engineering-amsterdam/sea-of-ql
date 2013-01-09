package org.uva.sea.ql.ast;

public class IntLiteral extends Expr {

	private final int value;

	public IntLiteral(int n) {
		super(null, null);
		this.value = n;
	}

	public int getValue() {
		return value;
	}

	public void eval() {

		System.out.print(value);

	}
}
