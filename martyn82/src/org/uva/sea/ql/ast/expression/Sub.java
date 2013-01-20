package org.uva.sea.ql.ast.expression;


/**
 * Represents a subtraction expression.
 */
public class Sub extends ArithmeticExpression {
	/**
	 * Constructs a new subtraction expression.
	 *
	 * @param lhs The left-hand side.
	 * @param rhs The right-hand side.
	 */
	public Sub( Expression lhs, Expression rhs ) {
		super( lhs, rhs );
	}
}
