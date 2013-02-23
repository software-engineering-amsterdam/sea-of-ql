package org.uva.sea.ql.ast.expressions.unary;

import org.uva.sea.ql.ast.expressions.Expression;


public abstract class UnaryExpression extends Expression {
	private final Expression _expr;
	
	protected UnaryExpression(Expression expression) {
		_expr = expression;
	}
	
	public Expression getExpr() {
		return _expr;
	}
}