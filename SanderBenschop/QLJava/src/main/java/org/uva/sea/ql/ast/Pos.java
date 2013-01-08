package org.uva.sea.ql.ast;

public class Pos extends Expr<Integer> {

	private final int value;
	
	public Pos(Expr<Integer> x) {
		this.value = 0;
	}
	
	@Override
	public Integer getValue() {
		return value;
	}

}
