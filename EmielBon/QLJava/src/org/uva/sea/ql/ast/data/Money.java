package org.uva.sea.ql.ast.data;

import org.uva.sea.ql.ast.Expression;

public class Money extends Expression {

	private final int value;

	public Money(int n) {
		this.value = n;
	}

	public int getValue() {
		return value;
	}
	
}
