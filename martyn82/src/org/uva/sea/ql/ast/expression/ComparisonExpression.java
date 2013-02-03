package org.uva.sea.ql.ast.expression;

/**
 * Represents a Comparison expression.
 */
abstract public class ComparisonExpression extends BinaryExpression {
	/**
	 * Constructs a new Comparison instance.
	 *
	 * @param lhs The left-hand side expression.
	 * @param rhs The right-hand side expression.
	 */
	protected ComparisonExpression( Expression lhs, Expression rhs ) {
		super( lhs, rhs );
	}
}
