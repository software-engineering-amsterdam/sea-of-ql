package org.uva.sea.ql.ast.expr.value;

public class MoneyLiteral extends Value {

	private final double value;

	public MoneyLiteral(double value) {
		this.value = value;
	}

	public double getValue() {
		return value;
	}

}
