package org.uva.sea.ql.ast.expression;


/**
 * Represents a logical OR expression.
 */
public class Or extends LogicalExpression {
	/**
	 * Constructs a new logical OR expression.
	 *
	 * @param lhs The left-hand side.
	 * @param rhs The right-hand side.
	 */
	public Or( Expression lhs, Expression rhs ) {
		super( lhs, rhs );
	}
}
