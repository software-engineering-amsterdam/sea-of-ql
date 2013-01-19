package org.uva.sea.ql.ast.expression;

import org.uva.sea.ql.visitor.INodeVisitor;

/**
 * Represents an arithmetic expression.
 */
abstract public class ArithmeticExpression extends BinaryExpression {
	/**
	 * Constructs a new ArithmeticExpression instance.
	 *
	 * @param lhs The left-hand side expression.
	 * @param rhs The right-hand side expression.
	 */
	protected ArithmeticExpression( Expression lhs, Expression rhs ) {
		super( lhs, rhs );
	}

	@Override
	public void accept( INodeVisitor visitor ) {
		visitor.visit( this );
	}
}
