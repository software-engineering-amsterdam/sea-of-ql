package org.uva.sea.ql.ast;


public class Not extends Expr<Boolean> {

	private final boolean value;
	
	public Not(Expr<Boolean> x) {
		this.value = false;
	}

	@Override
	public Boolean getValue() {
		return value;
	}
	
}
