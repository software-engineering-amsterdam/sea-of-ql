package org.uva.sea.ql.ast;

public class IntLiteral extends Expr {

	public final int value;

	public IntLiteral(int n) {
		this.value = n;
	}

	public int getValue() {
		return value;
	}

	public void eval() {

		System.out.print(value);

	}
}
