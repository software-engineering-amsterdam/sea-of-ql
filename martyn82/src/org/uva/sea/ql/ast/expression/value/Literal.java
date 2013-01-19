package org.uva.sea.ql.ast.expression.value;

import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.visitor.typecheck.TypeChecker;

/**
 * Represents a literal expression.
 */
abstract public class Literal extends Expression {
	/**
	 * Returns a string representation of this object.
	 */
	@Override
	abstract public String toString();

	/**
	 * Evaluates the type of this literal.
	 *
	 * @param visitor
	 *
	 * @return The evaluated type.
	 */
	abstract public Type accept( TypeChecker visitor );
}
