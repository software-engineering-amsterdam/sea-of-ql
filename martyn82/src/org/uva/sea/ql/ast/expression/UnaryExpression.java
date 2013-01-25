package org.uva.sea.ql.ast.expression;

import java.util.Map;

import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.visitor.NodeVisitor;

/**
 * Represents a unary expression.
 */
abstract public class UnaryExpression extends Expression {
	/**
	 * Holds the expression.
	 */
	private final Expression expression;

	/**
	 * Constructs a new UnaryExpression.
	 *
	 * @param expression
	 */
	protected UnaryExpression( Expression expression ) {
		this.expression = expression;
	}

	/**
	 * Retrieves the expression.
	 *
	 * @return The expression.
	 */
	public Expression getExpression() {
		return this.expression;
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
