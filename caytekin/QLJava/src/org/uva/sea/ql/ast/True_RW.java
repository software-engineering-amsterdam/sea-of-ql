package org.uva.sea.ql.ast;

public class True_RW extends Expr {

	private final String value;

	public True_RW(String s) {
		this.value = s;
	}

	public String getValue() {
		return value;
	}
	
}
