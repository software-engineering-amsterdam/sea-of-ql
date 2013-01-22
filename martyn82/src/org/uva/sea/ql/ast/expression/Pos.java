package org.uva.sea.ql.ast.expression;

/**
 * Represents a positive expression.
 */
public class Pos extends UnaryNumericExpression {
	/**
	 * Constructs a new positive expression.
	 *
	 * @param expression
	 */
	public Pos( Expression expression ) {
		super( expression );
	}
}
