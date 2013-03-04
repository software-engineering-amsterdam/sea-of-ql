package org.uva.sea.ql.ast.primaryexpr;

public class Str extends PrimaryExpr {
	private final String value;

	public Str(String s) {
		this.value = s;
	}
	
	public String getValue() {
		return value;
	}
}
