package org.uva.sea.ql.ast.primary;

public final class Bool extends ValuedPrimaryExpression<Boolean> {

	private final boolean value;
	
	public Bool(boolean value) {
		this.value = value;
	}
	
	@Override
	public Boolean getValue() {
		return value;
	}
}
