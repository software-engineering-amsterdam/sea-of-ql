package org.uva.sea.ql.ast;

public class Boolean_Type extends Type {

	private final boolean value;

	public Boolean_Type(String s) {
		super(s);
		this.value = false;
		// TODO
	}

	public boolean getValue() {
		return value;
	}
	
}
