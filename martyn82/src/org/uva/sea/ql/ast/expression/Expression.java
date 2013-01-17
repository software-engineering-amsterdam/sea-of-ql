package org.uva.sea.ql.ast.expression;

import org.uva.sea.ql.ast.Node;
import org.uva.sea.ql.ast.type.Type;

/**
 * Represents an expression.
 */
abstract public class Expression implements Node {
	/**
	 * Determines whether the type of this expression conforms to semantics.
	 * 
	 * @return True if type of expression is OK, false otherwise.
	 */
	abstract public boolean checkType();
	
	/**
	 * Determines and retrieves the type of the expression.
	 * 
	 * @return The actual type of the expression.
	 */
	abstract public Type getType();
}
