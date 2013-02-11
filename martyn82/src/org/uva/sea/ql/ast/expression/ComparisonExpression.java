package org.uva.sea.ql.ast.expression;

abstract public class ComparisonExpression extends BinaryExpression {
	protected ComparisonExpression( Expression lhs, Expression rhs ) {
		super( lhs, rhs );
	}
}
