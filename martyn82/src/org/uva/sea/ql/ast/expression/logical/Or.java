package org.uva.sea.ql.ast.expression.logical;

import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.expression.LogicalExpression;
import org.uva.sea.ql.visitor.IExpressionVisitor;

/**
 * Represents a logical OR expression.
 */
public class Or extends LogicalExpression {
	/**
	 * Constructs a new logical OR expression.
	 *
	 * @param lhs The left-hand side.
	 * @param rhs The right-hand side.
	 */
	public Or( Expression lhs, Expression rhs ) {
		super( lhs, rhs );
	}

	@Override
	public <T> T accept( IExpressionVisitor<T> visitor ) {
		return visitor.visit( this );
	}
}
