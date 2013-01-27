package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.exp.Expression;

public class IntegerLiteral extends Expression {

	private final int value;

	public IntegerLiteral(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
	
}
