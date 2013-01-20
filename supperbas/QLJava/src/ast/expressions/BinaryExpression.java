package ast.expressions;

import ast.Expression;


public class BinaryExpression extends Expression {
	
	private final Expression lhs;
	private final Expression rhs;

	public BinaryExpression(Expression lhs, Expression rhs) {
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
