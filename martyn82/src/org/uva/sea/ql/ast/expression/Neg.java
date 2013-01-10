package org.uva.sea.ql.ast.expression;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.interpreter.Context;
import org.uva.sea.ql.interpreter.Value;

/**
 * Represents a negative expression.
 */
public class Neg extends UnaryExpression {
	/**
	 * Constructs a new negative expression.
	 * 
	 * @param expression
	 */
	public Neg( Expression expression ) {
		super( expression );
	}

	@Override
	public Value eval( Context context ) {
		// TODO Auto-generated method stub
		return null;
	}
}
