package org.uva.sea.ql.ast.expression;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.interpreter.Context;
import org.uva.sea.ql.interpreter.Value;

/**
 * Represents a logical NOT expression.
 */
public class Not extends UnaryExpression {
	/**
	 * Constructs a new logical NOT expression.
	 * 
	 * @param expression
	 */
	public Not( Expression expression ) {
		super( expression );
	}

	@Override
	public Value eval( Context context ) {
		// TODO Auto-generated method stub
		return null;
	}
}
