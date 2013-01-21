package org.uva.sea.ql.ast;

public class StringLiteral extends Expr {

	private final String value;

	public StringLiteral(String string) {
		super(new StringType());
		value = string;
	}

	public String getValue() {
		return value;
	}
}
