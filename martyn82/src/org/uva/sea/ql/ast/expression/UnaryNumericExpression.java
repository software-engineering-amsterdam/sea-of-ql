package org.uva.sea.ql.ast.expression;

/**
 * Represents a unary numerical expression.
 */
abstract public class UnaryNumericExpression extends UnaryExpression {
	/**
	 * Constructs a new unary numerical expression.
	 * 
	 * @param expression The expression.
	 */
	protected UnaryNumericExpression( Expression expression ) {
		super( expression );
	}
}
