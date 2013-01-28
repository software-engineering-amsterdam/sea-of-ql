package org.uva.sea.ql.ast.expr.atom;

import org.uva.sea.ql.visitor.IExpression;

public class Money extends Numeric {

	private final float value;

	public Money(float value) {
		this.value = value;
	}

	public Float getValue() {
		return this.value;
	}

	@Override
	public <T> T accept(IExpression<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public java.lang.String toString() {
		return java.lang.String.format("Money (%.2f)", this.getValue());
	}

}
