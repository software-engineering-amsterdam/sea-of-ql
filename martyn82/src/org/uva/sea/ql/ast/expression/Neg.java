package org.uva.sea.ql.ast.expression;

import org.uva.sea.ql.visitor.IExpressionVisitor;

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

	@Override
	public <T> T accept( IExpressionVisitor<T> visitor ) {
		return visitor.visit( this );
	}
}
