package org.uva.sea.ql.parser.antlr.operators;

import org.uva.sea.ql.ast.Expression;

public class Money extends Expression {
	private double value;

	public Money(String value) {
		this.value = Double.parseDouble(value);
	}
	
	public Object getValue() {
		return value;
	}
}
