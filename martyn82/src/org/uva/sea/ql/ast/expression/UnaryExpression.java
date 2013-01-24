package org.uva.sea.ql.ast.expression;

import java.util.Map;

import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.eval.Environment;
import org.uva.sea.ql.visitor.INodeVisitor;

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
	public <T> T accept( INodeVisitor<T> visitor, Environment context ) {
		return visitor.visit( this, context );
	}

	@Override
	public Type typeOf( Map<Ident, Type> types ) {
		return new org.uva.sea.ql.ast.type.Bool();
	}
}
