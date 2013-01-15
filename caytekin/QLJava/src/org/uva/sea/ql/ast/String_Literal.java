package org.uva.sea.ql.ast;

public class String_Literal extends Expr {

	private final String value;

	public String_Literal(String s) {
		this.value = s;
	}

	public String getValue() {
		return value;
	}
	
}
