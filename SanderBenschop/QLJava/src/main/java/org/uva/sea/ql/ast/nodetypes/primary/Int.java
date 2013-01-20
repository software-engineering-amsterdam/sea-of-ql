package org.uva.sea.ql.ast.nodetypes.primary;

public final class Int extends Datatype<Integer> {

	private final int value;

	public Int(int value) {
		this.value = value;
	}

	@Override
	public Integer getValue() {
		return value;
	}
}
