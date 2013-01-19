package org.uva.sea.ql.ast.expression;

import org.uva.sea.ql.visitor.INodeVisitor;

/**
 * Represents a logical expression.
 */
abstract public class LogicalExpression extends BinaryExpression {
	/**
	 * Constructs a new LogicalExpression instance.
	 *
	 * @param lhs The left-hand side expression.
	 * @param rhs The right-hand side expression.
	 */
	protected LogicalExpression( Expression lhs, Expression rhs ) {
		super( lhs, rhs );
	}

	@Override
	public void accept( INodeVisitor visitor ) {
		visitor.visit( this );
	}
}
