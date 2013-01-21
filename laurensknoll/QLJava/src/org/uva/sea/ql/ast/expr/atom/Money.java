package org.uva.sea.ql.ast.expr.atom;

import org.uva.sea.ql.visitor.Expression;

public class Money extends Numeric {

	private final float value;

	public Money(float value) {
		this.value = value;
	}

	public Float getValue() {
		return this.value;
	}

	@Override
	public void accept(Expression<?> visitor) {
		visitor.visit(this);
	}

}
