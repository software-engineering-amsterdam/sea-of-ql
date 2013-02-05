package org.uva.sea.ql.ast.expression.unary;

import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.expression.UnaryNumericExpression;
import org.uva.sea.ql.visitor.IExpressionVisitor;

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

	@Override
	public <T> T accept( IExpressionVisitor<T> visitor ) {
		return visitor.visit( this );
	}
}