package org.uva.sea.ql.ast;

public class String extends Expr {

	private final java.lang.String value;

	public String(java.lang.String s) {
		this.value = s;
	}

	public java.lang.String getValue() {
		return value;
	}
	
}
