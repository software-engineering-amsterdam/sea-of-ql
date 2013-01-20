package org.uva.sea.ql.ast;

public class Bool extends Expr {
	private final String value;

	public Bool(String n) {
		this.value = n;
	}

	public String getValue() {
		return value;
	}
}
