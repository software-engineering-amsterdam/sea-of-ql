package org.uva.sea.ql.ast.expr.type;

import org.uva.sea.ql.visitor.ExpressionVisitor;

public class IdentExprType extends AbstractExprType {

	private final String value;

	public IdentExprType(String value) {
		this.value = value;
	}

	public String getName() {
		return value;
	}

	@Override
	public void accept(ExpressionVisitor visitor) {
		visitor.visit(this);
	}

}
