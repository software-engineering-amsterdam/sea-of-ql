package org.uva.sea.ql.ast.expression;

/**
 * Represents a logical AND expression.
 */
public class And extends LogicalExpression {
	/**
	 * Constructs a new logical AND expression.
	 *
	 * @param lhs The left-hand side.
	 * @param rhs The right-hand side.
	 */
	public And( Expression lhs, Expression rhs ) {
		super( lhs, rhs );
	}
}
