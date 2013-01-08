package org.uva.sea.ql.ast;

public class Eq extends Expr<Boolean> {

	private final boolean value;
	
	public Eq(Expr<Integer> leftHandSide, Expr<Integer> rightHandSide) {
		this.value = leftHandSide.getValue() == rightHandSide.getValue();
	}

	@Override
	public Boolean getValue() {
		return value;
	}
}
