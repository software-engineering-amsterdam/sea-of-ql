package org.uva.sea.ql.ast;

public class Sub extends Expr<Integer> {
	
	private final int value;
	
	public Sub(Expr<Integer> leftHandSide, Expr<Integer> rightHandSide) {
		this.value = 0;
	}

	@Override
	public Integer getValue() {
		return value;
	}
	
}
