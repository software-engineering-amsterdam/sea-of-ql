package org.uva.sea.ql.ast.expression.unary;

import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.expression.UnaryNumericExpression;
import org.uva.sea.ql.visitor.ExpressionVisitor;

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
	public <T> T accept( ExpressionVisitor<T> visitor ) {
		return visitor.visit( this );
	}
}
