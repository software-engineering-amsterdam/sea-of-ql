package org.uva.sea.ql.ast;

import org.uva.sea.ql.interpreter.Context;
import org.uva.sea.ql.interpreter.Value;

/**
 * Represents an expression.
 */
abstract public class Expression implements ASTNode {
	/**
	 * Evaluates the Expression.
	 * 
	 * @param context The evaluation environment.
	 * 
	 * @return The value the expression produces.
	 */
	abstract public Value eval( Context context );
}
