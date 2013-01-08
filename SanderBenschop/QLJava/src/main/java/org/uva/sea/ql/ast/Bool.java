package org.uva.sea.ql.ast;

public class Bool extends Expr {

	private final boolean value;
	
	public Bool(boolean value) {
		this.value = value;
	}
	
	public boolean getValue() {
		return value;
	}
}
