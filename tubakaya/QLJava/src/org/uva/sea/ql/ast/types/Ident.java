package org.uva.sea.ql.ast.types;

public class Ident extends Expr{
	private final String value;

	public Ident(String string) {
		value = string;
	}

	public String getValue() {
		return value;
	}
}
