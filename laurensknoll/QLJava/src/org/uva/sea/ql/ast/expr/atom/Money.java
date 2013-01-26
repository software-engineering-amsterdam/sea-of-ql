package org.uva.sea.ql.ast.expr.atom;

import org.uva.sea.ql.ast.type.AbstractType;
import org.uva.sea.ql.visitor.Expression;
import org.uva.sea.ql.visitor.semantic.Environment;

public class Money extends Numeric {

	private final float value;

	public Money(float value) {
		this.value = value;
	}

	public Float getValue() {
		return this.value;
	}

	@Override
	public <T> T accept(Expression<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public AbstractType typeOf(Environment environment) {
		return new org.uva.sea.ql.ast.type.Money();
	}

}
