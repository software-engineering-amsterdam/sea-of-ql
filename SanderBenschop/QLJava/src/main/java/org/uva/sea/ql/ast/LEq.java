package org.uva.sea.ql.ast;


public class LEq extends Expr<Boolean> {

	private final boolean value;
	
	public LEq(Expr<Integer> leftHandSide, Expr<Integer> rightHandSide) {
		this.value = false;
	}

	@Override
	public Boolean getValue() {
		return value;
	}
}
