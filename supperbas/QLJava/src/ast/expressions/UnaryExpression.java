package ast.expressions;

import ast.Expression;


public class UnaryExpression extends Expression {
	
	private final Expression expr;

	public UnaryExpression(Expression expr) {
		this.expr = expr;
	}

	public Expression getExpr() {
		return expr;
	}

}
