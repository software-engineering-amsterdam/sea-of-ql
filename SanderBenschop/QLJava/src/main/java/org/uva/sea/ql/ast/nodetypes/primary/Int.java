package org.uva.sea.ql.ast.nodetypes.primary;

public final class Int extends Primary<Integer> {

	private final int value;

	public Int(int n) {
		this.value = n;
	}

	@Override
	public Integer getValue() {
		return value;
	}
}
