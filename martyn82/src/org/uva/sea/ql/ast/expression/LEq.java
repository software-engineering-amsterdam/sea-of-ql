package org.uva.sea.ql.ast.expression;

import org.uva.sea.ql.visitor.IExpressionVisitor;

/**
 * Represents a less-than-equals expression.
 */
public class LEq extends ComparisonExpression {
	/**
	 * Constructs a new lesser-than-equals expression.
	 *
	 * @param lhs The left-hand side.
	 * @param rhs The right-hand side.
	 */
	public LEq( Expression lhs, Expression rhs ) {
		super( lhs, rhs );
	}

	@Override
	public <T> T accept( IExpressionVisitor<T> visitor ) {
		return visitor.visit( this );
	}
}
