package org.uva.sea.ql.ast;

public class If_RW extends Expr {

	private final String value;

	public If_RW(String s) {
		this.value = s;
	}

	public String getValue() {
		return value;
	}
	
}
