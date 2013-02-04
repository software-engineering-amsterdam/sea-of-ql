package org.uva.sea.ql.ast.types;

public class BooleanLiteral extends Expr {
	private final String value;

	public BooleanLiteral(String string) {
		value = string.toLowerCase();
	}

	public String getValue() {
		return value;
	}

}
