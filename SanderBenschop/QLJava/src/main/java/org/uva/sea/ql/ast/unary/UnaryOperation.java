package org.uva.sea.ql.ast.unary;

import org.uva.sea.ql.ast.QLExpression;

public abstract class UnaryOperation implements QLExpression {

	private final QLExpression expression;

	public UnaryOperation(QLExpression expression) {
		this.expression = expression;
	}

	public QLExpression getExpression() {
		return expression;
	}
}
