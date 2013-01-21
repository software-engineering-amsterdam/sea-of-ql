package org.uva.sea.ql.ast;

public abstract class BinaryExpression extends Expression {
	private final Expression lhs;
	private final Expression rhs;

	public BinaryExpression(Expression lhs, Expression rhs) {
		this.lhs = lhs;
		this.rhs = rhs;
	}

	public Expression getLhs() {
		return lhs;
	}

	public Expression getRhs() {
		return rhs;
	}
}
