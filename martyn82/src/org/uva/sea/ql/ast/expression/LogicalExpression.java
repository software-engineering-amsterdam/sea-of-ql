package org.uva.sea.ql.ast.expression;

import java.util.Map;

import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.visitor.NodeVisitor;

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
	public <T> T accept( NodeVisitor<T> visitor ) {
		return visitor.visit( this );
	}

	@Override
	public Type typeOf( Map<Ident, Type> types ) {
		return new org.uva.sea.ql.ast.type.Bool();
	}
}
