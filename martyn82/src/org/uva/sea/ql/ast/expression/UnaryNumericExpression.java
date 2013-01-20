package org.uva.sea.ql.ast.expression;

import org.uva.sea.ql.evaluate.Context;
import org.uva.sea.ql.evaluate.Value;
import org.uva.sea.ql.visitor.INodeVisitor;

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
	public Value accept( INodeVisitor visitor, Context context ) {
		return visitor.visit( this, context );
	}
}
