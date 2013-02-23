package org.uva.sea.ql.ast.expressions.binary;

import org.uva.sea.ql.ast.expressions.Expression;


public abstract class BinaryExpression extends Expression {
	private final Expression _lhs, _rhs;
	
	protected BinaryExpression(Expression lhs, Expression rhs) {
		_lhs = lhs;
		_rhs = rhs;
	}
	
	public Expression getLhs() {
		return _lhs;
	}
	
	public Expression getRhs() {
		return _rhs;
	}
}