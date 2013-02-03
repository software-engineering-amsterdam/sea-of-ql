package org.uva.sea.ql.ast.types;

public class INT extends Expr {

	private final int value;

	public INT(int n) {
		this.value = n;
	}

	public int getValue() {
		return value;
	}
	
}
