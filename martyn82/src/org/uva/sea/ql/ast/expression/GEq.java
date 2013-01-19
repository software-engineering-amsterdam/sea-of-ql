package org.uva.sea.ql.ast.expression;


/**
 * Represents a greater-than-equals expression.
 */
public class GEq extends ComparisonExpression {
	/**
	 * Constructs a new greater-than-equals expression.
	 *
	 * @param lhs The left-hand side.
	 * @param rhs The right-hand side.
	 */
	public GEq( Expression lhs, Expression rhs ) {
		super( lhs, rhs );
	}
}
