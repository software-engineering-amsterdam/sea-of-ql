package org.uva.sea.ql.ast;

public class Neg extends Expr<Integer> {

	private final int value;
	
	public Neg(Expr<Integer> x) {
		this.value = 0;
	}
	
	@Override
	public Integer getValue() {
		return value;
	}

}
