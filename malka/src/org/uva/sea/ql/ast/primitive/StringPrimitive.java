package org.uva.sea.ql.ast.primitive;

import org.uva.sea.ql.ast.Expression;

public class StringPrimitive extends Expression {
	private final String value;
	
	public StringPrimitive(String str) {
		this.value = str;
	}
	
	public String getValue() {
		return this.value;
	}
}
