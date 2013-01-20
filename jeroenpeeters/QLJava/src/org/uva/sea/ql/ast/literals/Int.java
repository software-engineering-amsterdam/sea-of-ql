package org.uva.sea.ql.ast.literals;

import org.uva.sea.ql.ast.Literal;

public class Int extends Literal {

	private final int value;

	public Int(int n) {
		this.value = n;
	}

	public int getValue() {
		return value;
	}
	
}
