package org.uva.sea.ql.ast.expression;

import org.uva.sea.ql.ast.Expression;

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
	protected Expression getExpression() {
		return this.expression;
	}
}
