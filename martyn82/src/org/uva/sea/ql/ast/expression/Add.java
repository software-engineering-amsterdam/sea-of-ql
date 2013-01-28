package org.uva.sea.ql.ast.expression;

/**
 * Represents an addition expression.
 */
public class Add extends ArithmeticExpression {
	/**
	 * Constructs a new addition expression.
	 *
	 * @param lhs The left-hand side.
	 * @param rhs The right-hand side.
	 */
	public Add( Expression lhs, Expression rhs ) {
		super( lhs, rhs );
	}
}
