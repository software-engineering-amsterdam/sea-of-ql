package ast.expressions;

import ast.Expression;


public abstract class Binary extends Expression {
	
	private final Expression lhs;
	private final Expression rhs;

	public Binary(Expression lhs, Expression rhs) {
		this.lhs = lhs;
		this.rhs = rhs;
	}

	public Expression getRhs() {
		return rhs;
	}

	public Expression getLhs() {
		return lhs;
	}

}
