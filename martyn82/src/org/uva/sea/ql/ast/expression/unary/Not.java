package org.uva.sea.ql.ast.expression.unary;

import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.expression.UnaryExpression;
import org.uva.sea.ql.visitor.IExpressionVisitor;

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

	@Override
	public <T> T accept( IExpressionVisitor<T> visitor ) {
		return visitor.visit( this );
	}
}
