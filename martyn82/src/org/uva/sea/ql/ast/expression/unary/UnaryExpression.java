package org.uva.sea.ql.ast.expression.unary;

import org.uva.sea.ql.ast.expression.Expression;

abstract public class UnaryExpression extends Expression {
	private final Expression expression;

	protected UnaryExpression( Expression expression ) {
		this.expression = expression;
	}

	public Expression getExpression() {
		return this.expression;
	}
}