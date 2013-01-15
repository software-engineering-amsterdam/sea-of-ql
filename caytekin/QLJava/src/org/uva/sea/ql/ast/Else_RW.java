package org.uva.sea.ql.ast;

public class Else_RW extends Expr {

	private final String value;

	public Else_RW(String s) {
		this.value = s;
	}

	public String getValue() {
		return value;
	}
	
}
