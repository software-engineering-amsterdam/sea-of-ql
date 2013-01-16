package org.uva.sea.ql.ast;

public class Integer_Type extends Type {

	private final String value;

	public Integer_Type(String s) {
		super(s);
		this.value = s;
		// TODO
	}

	public String getValue() {
		return value;
	}
	
}
