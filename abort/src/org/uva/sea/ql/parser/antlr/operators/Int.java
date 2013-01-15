package org.uva.sea.ql.parser.antlr.operators;

import org.uva.sea.ql.ast.Expression;

public class Int extends Expression {

	private final int value;

	public Int(int n) {
		this.value = n;
	}

	public Object getValue() {
		return value;
	}
	
}
