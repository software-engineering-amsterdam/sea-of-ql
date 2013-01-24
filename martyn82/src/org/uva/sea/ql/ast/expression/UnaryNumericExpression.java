package org.uva.sea.ql.ast.expression;

import java.util.Map;

import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.eval.Environment;
import org.uva.sea.ql.visitor.NodeVisitor;

/**
 * Represents a unary numerical expression.
 */
abstract public class UnaryNumericExpression extends UnaryExpression {
	/**
	 * Constructs a new unary numerical expression.
	 *
	 * @param expression The expression.
	 */
	protected UnaryNumericExpression( Expression expression ) {
		super( expression );
	}

	@Override
	public <T> T accept( NodeVisitor<T> visitor, Environment context ) {
		return visitor.visit( this, context );
	}

	@Override
	public Type typeOf( Map<Ident, Type> types ) {
		return new org.uva.sea.ql.ast.type.Number();
	}
}
