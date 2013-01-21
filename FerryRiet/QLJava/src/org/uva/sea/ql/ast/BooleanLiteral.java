package org.uva.sea.ql.ast;

public class BooleanLiteral extends Expr {
	private final String value;

	public BooleanLiteral(String string) {
		super(new BooleanType());
		value = string;
	}

	public String getValue() {
		return value;
	}
}
