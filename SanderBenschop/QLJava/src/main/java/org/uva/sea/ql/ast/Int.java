package org.uva.sea.ql.ast;

public class Int extends Expr<Integer> {

	private final int value;

	public Int(int n) {
		this.value = n;
	}

	@Override
	public Integer getValue() {
		return value;
	}
	
}
