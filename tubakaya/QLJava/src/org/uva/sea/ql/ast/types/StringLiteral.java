package org.uva.sea.ql.ast.types;

public class StringLiteral extends Expr {

	private final String value;

	public StringLiteral(String string) {
		value = string;
	}

	public String getValue() {
		return value;
	}

}
