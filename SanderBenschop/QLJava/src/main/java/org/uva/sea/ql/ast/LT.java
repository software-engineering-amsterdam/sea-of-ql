package org.uva.sea.ql.ast;

public class LT extends Expr<Boolean> {
	
	private final boolean value;
	
	public LT(Expr<Integer> leftHandSide, Expr<Integer> rightHandSide) {
		this.value = false;
	}

	@Override
	public Boolean getValue() {
		return value;
	}
}
