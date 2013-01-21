package org.uva.sea.ql.ast.expr.type;

import org.uva.sea.ql.visitor.ExpressionVisitor;

public class StringExprType extends AbstractExprType {

	private final String value;

	public StringExprType(String value) {
		this.value = value;
	}

	public String getName() {
		return value;
	}

	@Override
	public void accept(ExpressionVisitor<?> visitor) {
		visitor.visit(this);
	}

}
