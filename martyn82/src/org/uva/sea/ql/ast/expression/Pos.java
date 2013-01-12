package org.uva.sea.ql.ast.expression;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.interpreter.Context;
import org.uva.sea.ql.interpreter.Value;

/**
 * Represents a positive expression.
 */
public class Pos extends UnaryExpression {
	/**
	 * Constructs a new positive expression.
	 * 
	 * @param expression
	 */
	public Pos( Expression expression ) {
		super( expression );
	}

	@Override
	public Value eval( Context context ) {
		// TODO Auto-generated method stub
		return null;
	}
}
