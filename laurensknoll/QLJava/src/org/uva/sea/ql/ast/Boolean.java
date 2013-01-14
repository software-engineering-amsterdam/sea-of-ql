package org.uva.sea.ql.ast;

public class Boolean extends Expr {

	private final boolean value;

	public Boolean(boolean b) {
		this.value = b;
	}

	public boolean getValue() {
		return this.value;
	}
	
}
