package org.uva.sea.ql.ast;

public class Boolean extends Expr {
	private final int value;

	public Boolean(int n) {
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
