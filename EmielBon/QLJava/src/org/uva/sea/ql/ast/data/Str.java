package org.uva.sea.ql.ast.data;

import org.uva.sea.ql.ast.Expression;

public class Str extends Expression {

	private final String value;

	public Str(String s) {
		this.value = s;
	}

	public String getValue() {
		return value;
	}
	
}
