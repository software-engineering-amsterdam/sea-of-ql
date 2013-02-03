package org.uva.sea.ql.ast.expression;

/**
 * Represents a unary expression.
 */
abstract public class UnaryExpression extends Expression {
	/**
	 * Holds the expression.
	 */
	private final Expression expression;

	/**
	 * Constructs a new UnaryExpression.
	 *
	 * @param expression
	 */
	protected UnaryExpression( Expression expression ) {
		this.expression = expression;
	}

	/**
	 * Retrieves the expression.
	 *
	 * @return The expression.
	 */
	public Expression getExpression() {
		return this.expression;
	}
}
