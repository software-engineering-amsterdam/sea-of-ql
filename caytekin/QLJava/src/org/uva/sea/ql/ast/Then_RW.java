package org.uva.sea.ql.ast;

public class Then_RW extends Expr {

	private final String value;

	public Then_RW(String s) {
		this.value = s;
	}

	public String getValue() {
		return value;
	}
	
}
