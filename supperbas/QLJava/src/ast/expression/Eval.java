package ast.expression;

import ast.Expression;


public abstract class Eval extends Expression {
	
	private final Expression lhs;
	private final Expression rhs;

	public Eval(Expression lhs, Expression rhs) {
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
