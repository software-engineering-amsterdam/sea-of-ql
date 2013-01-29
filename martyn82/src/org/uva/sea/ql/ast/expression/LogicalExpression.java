package org.uva.sea.ql.ast.expression;

/**
 * Represents a logical expression.
 */
abstract public class LogicalExpression extends BinaryExpression {
	/**
	 * Constructs a new LogicalExpression instance.
	 *
	 * @param lhs The left-hand side expression.
	 * @param rhs The right-hand side expression.
	 */
	protected LogicalExpression( Expression lhs, Expression rhs ) {
		super( lhs, rhs );
	}
}
