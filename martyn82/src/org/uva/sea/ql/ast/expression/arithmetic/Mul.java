package org.uva.sea.ql.ast.expression.arithmetic;

import org.uva.sea.ql.ast.expression.ArithmeticExpression;
import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.visitor.ExpressionVisitor;

/**
 * Represents a multiplication expression.
 */
public class Mul extends ArithmeticExpression {
	/**
	 * Constructs a new multiplication expression.
	 *
	 * @param lhs The left-hand side.
	 * @param rhs The right-hand side.
	 */
	public Mul( Expression lhs, Expression rhs ) {
		super( lhs, rhs );
	}

	@Override
	public <T> T accept( ExpressionVisitor<T> visitor ) {
		return visitor.visit( this );
	}
}
