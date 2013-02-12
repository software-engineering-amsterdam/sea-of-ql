package org.uva.sea.ql.ast.expression;

abstract public class LogicalExpression extends BinaryExpression {
	protected LogicalExpression( Expression lhs, Expression rhs ) {
		super( lhs, rhs );
	}
}
