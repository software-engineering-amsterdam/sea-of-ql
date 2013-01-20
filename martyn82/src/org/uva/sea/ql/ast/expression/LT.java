package org.uva.sea.ql.ast.expression;


/**
 * Represents a less-than expression.
 */
public class LT extends ComparisonExpression {
	/**
	 * Constructs a new lesser-than expression.
	 *
	 * @param lhs The left-hand side.
	 * @param rhs The right-hand side.
	 */
	public LT( Expression lhs, Expression rhs ) {
		super( lhs, rhs );
	}
}
