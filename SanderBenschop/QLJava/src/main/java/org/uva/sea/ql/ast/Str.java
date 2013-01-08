package org.uva.sea.ql.ast;

public class Str extends Expr<String> {

	private final String value;
	
	public Str(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}
