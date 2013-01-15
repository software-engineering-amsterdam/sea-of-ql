package org.uva.sea.ql.ast;

public class String_Type extends Expr {

	private final String value;

	public String_Type(String s) {
		this.value = s;
		// TODO
	}

	public String getValue() {
		return value;
	}
	
}
