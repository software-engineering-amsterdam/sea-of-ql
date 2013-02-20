package org.uva.sea.ql.ast.expression.binary;

import org.uva.sea.ql.ast.expression.Expression;

abstract public class BinaryExpression extends Expression {
	private final Expression lhs;
	private final Expression rhs;

	protected BinaryExpression( Expression lhs, Expression rhs ) {
		assert ( lhs != null ) && ( rhs != null );

		this.lhs = lhs;
		this.rhs = rhs;
	}

	public Expression getLhs() {
		return this.lhs;
	}

	public Expression getRhs() {
		return this.rhs;
	}
}
