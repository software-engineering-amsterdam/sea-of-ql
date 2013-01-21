package org.uva.sea.ql.ast.expression;

/**
 * Represents a logical NOT expression.
 */
public class Not extends UnaryExpression {
	/**
	 * Constructs a new logical NOT expression.
	 *
	 * @param expression
	 */
	public Not( Expression expression ) {
		super( expression );
	}
}
