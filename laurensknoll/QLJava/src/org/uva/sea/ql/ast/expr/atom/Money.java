package org.uva.sea.ql.ast.expr.atom;

import java.math.BigDecimal;
import java.text.NumberFormat;

import org.uva.sea.ql.visitor.IExpression;

public class Money extends Numeric {

	private final BigDecimal value;

	public Money(BigDecimal value) {
		this.value = value;
	}

	public BigDecimal getValue() {
		return this.value;
	}

	@Override
	public <T> T accept(IExpression<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public java.lang.String toString() {
		java.lang.String formattedValue = NumberFormat.getCurrencyInstance()
				.format(this.getValue());
		return java.lang.String.format("Money (%s)", formattedValue);
	}

}
