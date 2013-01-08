package org.uva.sea.ql.ast;

public class And extends Expr<Boolean> {

	private final boolean value;
	
	public And(Expr<Boolean> leftHandSide, Expr<Boolean> rightHandSide) {
		this.value = leftHandSide.getValue() && rightHandSide.getValue();
	}

	@Override
	public Boolean getValue() {
		return value;
	}
}
