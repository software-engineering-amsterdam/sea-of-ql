package org.uva.sea.ql.ast.expression;


/**
 * Represents an equation expression.
 */
public class Eq extends ComparisonExpression {
	/**
	 * Constructs a new equation expression.
	 *
	 * @param lhs The left-hand side.
	 * @param rhs The right-hand side.
	 */
	public Eq( Expression lhs, Expression rhs ) {
		super( lhs, rhs );
	}
}
