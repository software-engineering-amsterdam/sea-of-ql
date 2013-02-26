package org.uva.sea.ql.core.dom.operators;

import org.uva.sea.ql.core.dom.Expression;

public abstract class UnaryOperator extends Expression {

	private final Expression expression;

	public UnaryOperator(Expression expression) {
		this.expression = expression;
	}

	public Expression getExpression() {
		return expression;
	}
}
