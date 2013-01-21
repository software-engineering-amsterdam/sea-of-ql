package org.uva.sea.ql.ast.expr.type;

import org.uva.sea.ql.visitor.ExpressionVisitor;

public class BoolExprType extends AbstractExprType {

	private final boolean value;

	public BoolExprType(boolean value) {
		this.value = value;
	}

	public Boolean getValue() {
		return this.value;
	}

	@Override
	public void accept(ExpressionVisitor<?> visitor) {
		visitor.visit(this);
	}

}
