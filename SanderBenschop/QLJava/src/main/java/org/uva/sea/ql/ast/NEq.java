package org.uva.sea.ql.ast;

public class NEq extends Expr<Boolean> {
	
	private final boolean value;
	
	public NEq(Expr<Integer> leftHandSide, Expr<Integer> rightHandSide) {
		this.value = false;
	}

	@Override
	public Boolean getValue() {
		return value;
	}
}
