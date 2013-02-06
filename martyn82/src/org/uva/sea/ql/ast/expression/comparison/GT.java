package org.uva.sea.ql.ast.expression.comparison;

import org.uva.sea.ql.ast.expression.ComparisonExpression;
import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.visitor.ExpressionVisitor;

/**
 * Represents a greater-than expression.
 */
public class GT extends ComparisonExpression {
	/**
	 * Constructs a new greater-than expression.
	 *
	 * @param lhs The left-hand side.
	 * @param rhs The right-hand side.
	 */
	public GT( Expression lhs, Expression rhs ) {
		super( lhs, rhs );
	}

	@Override
	public <T> T accept( ExpressionVisitor<T> visitor ) {
		return visitor.visit( this );
	}
}
