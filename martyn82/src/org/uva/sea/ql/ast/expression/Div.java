package org.uva.sea.ql.ast.expression;


/**
 * Represents a division expression.
 */
public class Div extends ArithmeticExpression {
	/**
	 * Constructs a new Division expression.
	 *
	 * @param lhs The left-hand side.
	 * @param rhs The right-hand side.
	 */
	public Div( Expression lhs, Expression rhs ) {
		super( lhs, rhs );
	}
}
