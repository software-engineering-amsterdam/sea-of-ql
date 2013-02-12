package org.uva.sea.ql.ast.expression;

abstract public class ArithmeticExpression extends BinaryExpression {
	protected ArithmeticExpression( Expression lhs, Expression rhs ) {
		super( lhs, rhs );
	}
}
