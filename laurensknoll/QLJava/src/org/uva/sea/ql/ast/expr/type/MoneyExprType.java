package org.uva.sea.ql.ast.expr.type;

import org.uva.sea.ql.visitor.ExpressionVisitor;

public class MoneyExprType extends AbstractExprType {

	private final float value;

	public MoneyExprType(float value) {
		this.value = value;
	}

	public Float getValue() {
		return this.value;
	}

	@Override
	public void accept(ExpressionVisitor visitor) {
		visitor.visit(this);
	}

}
