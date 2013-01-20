package org.uva.sea.ql.ast.expression;

import org.uva.sea.ql.eval.Context;
import org.uva.sea.ql.eval.value.Value;
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
