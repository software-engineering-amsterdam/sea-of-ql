package org.uva.sea.ql.ast.expression;

/**
 * Represents a negative expression.
 */
public class Neg extends UnaryNumericExpression {
	/**
	 * Constructs a new negative expression.
	 *
	 * @param expression
	 */
	public Neg( Expression expression ) {
		super( expression );
	}
}
