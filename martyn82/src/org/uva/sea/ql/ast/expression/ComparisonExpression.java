package org.uva.sea.ql.ast.expression;

import java.util.Map;

import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.eval.Environment;
import org.uva.sea.ql.visitor.NodeVisitor;

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
	public <T> T accept( NodeVisitor<T> visitor, Environment context ) {
		return visitor.visit( this, context );
	}

	@Override
	public Type typeOf( Map<Ident, Type> types ) {
		return new org.uva.sea.ql.ast.type.Bool();
	}
}
