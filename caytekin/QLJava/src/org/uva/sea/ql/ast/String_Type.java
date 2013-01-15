package org.uva.sea.ql.ast;

public class String_Type extends Type {

	private final String value;

	public String_Type(String s) {
		super(s);
		this.value = s;
		// TODO
	}

	public String getValue() {
		return value;
	}
	
}
