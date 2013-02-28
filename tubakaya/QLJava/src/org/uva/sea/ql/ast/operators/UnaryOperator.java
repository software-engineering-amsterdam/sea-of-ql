package org.uva.sea.ql.ast.operators;

import org.uva.sea.ql.ast.Expression;

public abstract class UnaryOperator extends Expression {

	private final Expression expression;

	public UnaryOperator(Expression expression) {
		this.expression = expression;
	}

	public Expression getExpression() {
		return expression;
	}
}
