package org.uva.sea.ql.ast.expr.value;

public class StringLiteral extends Value {

	private final String value;

	public StringLiteral(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
}
