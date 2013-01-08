package org.uva.sea.ql.ast;

public class GEq extends Expr<Boolean> {

	private final boolean value;
	
	public GEq(Expr<Integer> leftHandSide, Expr<Integer> rightHandSide) {
		this.value = false;
	}

	@Override
	public Boolean getValue() {
		return value;
	}
}
