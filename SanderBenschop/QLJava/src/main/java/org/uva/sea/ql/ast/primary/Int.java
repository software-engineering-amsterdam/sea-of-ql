package org.uva.sea.ql.ast.primary;

public final class Int extends ValuedPrimaryExpression<Integer> {

	private final int value;

	public Int(int n) {
		this.value = n;
	}

	@Override
	public Integer getValue() {
		return value;
	}
}
