package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.exp.Expression;

public class Int extends Expression {

	private final int value;

	public Int(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
	
}
