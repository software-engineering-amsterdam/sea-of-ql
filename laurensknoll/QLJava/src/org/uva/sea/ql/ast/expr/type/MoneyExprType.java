package org.uva.sea.ql.ast.expr.type;

public class MoneyExprType extends AbstractExprType {

	private final float value;

	public MoneyExprType(float value) {
		this.value = value;
	}

	public Float getValue() {
		return this.value;
	}

}
