package org.uva.sea.ql.ast.expression;


/**
 * Represents a not-equals expression.
 */
public class NEq extends ComparisonExpression {
	/**
	 * Constructs a new not-equals expression.
	 *
	 * @param lhs The left-hand side.
	 * @param rhs The right-hand side.
	 */
	public NEq( Expression lhs, Expression rhs ) {
		super( lhs, rhs );
	}
}
