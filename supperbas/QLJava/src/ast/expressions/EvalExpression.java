package ast.expressions;

import ast.Expression;


public class EvalExpression extends Expression {
	
	private final Expression lhs;
	private final Expression rhs;

	public EvalExpression(Expression lhs, Expression rhs) {
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
