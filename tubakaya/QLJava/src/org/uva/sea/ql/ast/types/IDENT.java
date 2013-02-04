package org.uva.sea.ql.ast.types;

public class IDENT extends Expr{
	private final String value;

	public IDENT(String string) {
		value = string;
	}

	public String getValue() {
		return value;
	}
}
