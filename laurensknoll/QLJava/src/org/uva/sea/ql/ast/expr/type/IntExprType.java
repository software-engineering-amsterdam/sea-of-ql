package org.uva.sea.ql.ast.expr.type;

import org.uva.sea.ql.visitor.ExpressionVisitor;

public class IntExprType extends AbstractExprType {

	private final int value;

	public IntExprType(int n) {
		this.value = n;
	}

	public int getValue() {
		return this.value;
	}

	@Override
	public void accept(ExpressionVisitor<?> visitor) {
		visitor.visit(this);
	}

}
