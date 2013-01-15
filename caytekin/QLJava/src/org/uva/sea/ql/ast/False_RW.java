package org.uva.sea.ql.ast;

public class False_RW extends Expr {

	private final String value;

	public False_RW(String s) {
		this.value = s;
	}

	public String getValue() {
		return value;
	}
	
}
