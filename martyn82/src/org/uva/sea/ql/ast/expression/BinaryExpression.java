package org.uva.sea.ql.ast.expression;

import org.uva.sea.ql.ast.Expression;

/**
 * Represents a binary expression.
 */
abstract public class BinaryExpression extends Expression {
	/**
	 * Holds the left-hand side expression.
	 */
	private final Expression lhs;
	
	/**
	 * Holds the right-hand side expression.
	 */
	private final Expression rhs;
	
	/**
	 * Constructs a new BinaryExpression.
	 * 
	 * @param lhs The left-hand side of the expression.
	 * @param rhs The right-hand side of the expression
	 */
	protected BinaryExpression( Expression lhs, Expression rhs ) {
		this.lhs = lhs;
		this.rhs = rhs;
	}
	
	/**
	 * Retrieves the expression on the left-hand side.
	 * 
	 * @return The left-hand side expression.
	 */
	protected Expression getLhs() {
		return this.lhs;
	}
	
	/**
	 * Retrieves the expression on the right-hand side.
	 * 
	 * @return The right-hand side expression.
	 */
	protected Expression getRhs() {
		return this.rhs;
	}
}
