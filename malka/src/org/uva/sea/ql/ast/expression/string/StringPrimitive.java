package org.uva.sea.ql.ast.expression.string;

import org.uva.sea.ql.ast.expression.Expression;

public class StringPrimitive implements Expression {
	private final String value;
	
	public StringPrimitive(String str) {
		this.value = str;
	}
	
	public String getValue() {
		return this.value;
	}
}
