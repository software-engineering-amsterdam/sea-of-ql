package org.uva.sea.ql.ast;

public class StringLiteral extends Expr {

	private final String value;

	public StringLiteral(String s) {
		this.value = s;
	}

	public String getValue() {
		return value;
	}
	
}
