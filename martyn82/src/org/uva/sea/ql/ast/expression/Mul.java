package org.uva.sea.ql.ast.expression;


/**
 * Represents a multiplication expression.
 */
public class Mul extends ArithmeticExpression {
	/**
	 * Constructs a new multiplication expression.
	 *
	 * @param lhs The left-hand side.
	 * @param rhs The right-hand side.
	 */
	public Mul( Expression lhs, Expression rhs ) {
		super( lhs, rhs );
	}
}
