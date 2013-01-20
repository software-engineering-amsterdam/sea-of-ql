package org.uva.sea.ql.ast.expression;


/**
 * Represents a power expression.
 */
public class Pow extends ArithmeticExpression {
	/**
	 * Constructs a new power expression.
	 *
	 * @param lhs The left-hand side.
	 * @param rhs The right-hand side.
	 */
	public Pow( Expression lhs, Expression rhs ) {
		super( lhs, rhs );
	}
}
