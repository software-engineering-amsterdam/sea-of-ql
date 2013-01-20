package org.uva.sea.ql.ast.expression;

import org.uva.sea.ql.eval.Context;
import org.uva.sea.ql.eval.value.Value;
import org.uva.sea.ql.visitor.INodeVisitor;

/**
 * Represents a Comparison expression.
 */
abstract public class ComparisonExpression extends BinaryExpression {
	/**
	 * Constructs a new Comparison instance.
	 *
	 * @param lhs The left-hand side expression.
	 * @param rhs The right-hand side expression.
	 */
	protected ComparisonExpression( Expression lhs, Expression rhs ) {
		super( lhs, rhs );
	}

	@Override
	public Value accept( INodeVisitor visitor, Context context ) {
		return visitor.visit( this, context );
	}
}
