package org.uva.sea.ql.ast;

public class Int extends Expression {

	private final int value;

	public Int(int n) {
		this.value = n;
	}

	public int getValue() {
		return value;
	}
	
}
