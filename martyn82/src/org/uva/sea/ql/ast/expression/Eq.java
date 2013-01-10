package org.uva.sea.ql.ast.expression;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.interpreter.Context;
import org.uva.sea.ql.interpreter.Value;

/**
 * Represents an equation expression.
 */
public class Eq extends BinaryExpression {
	/**
	 * Constructs a new equation expression.
	 * 
	 * @param lhs The left-hand side.
	 * @param rhs The right-hand side.
	 */
	public Eq( Expression lhs, Expression rhs ) {
		super( lhs, rhs );
	}

	@Override
	public Value eval( Context context ) {
		// TODO Auto-generated method stub
		return null;
	}
}
