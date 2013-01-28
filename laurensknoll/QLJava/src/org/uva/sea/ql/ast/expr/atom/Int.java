package org.uva.sea.ql.ast.expr.atom;

import org.uva.sea.ql.visitor.IExpression;

public class Int extends Numeric {

	private final int value;

	public Int(int n) {
		this.value = n;
	}

	public int getValue() {
		return this.value;
	}

	@Override
	public <T> T accept(IExpression<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public java.lang.String toString() {
		return java.lang.String.format("Integer (%d)", this.getValue());
	}

}
