package org.uva.sea.ql.ast;

public class Bool extends Expr<Boolean> {

	private final boolean value;
	
	public Bool(boolean value) {
		this.value = value;
	}
	
	@Override
	public Boolean getValue() {
		return value;
	}
}
