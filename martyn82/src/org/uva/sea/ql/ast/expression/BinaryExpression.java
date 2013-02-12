package org.uva.sea.ql.ast.expression;

abstract public class BinaryExpression extends Expression {
	private final Expression lhs;
	private final Expression rhs;

	protected BinaryExpression( Expression lhs, Expression rhs ) {
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
