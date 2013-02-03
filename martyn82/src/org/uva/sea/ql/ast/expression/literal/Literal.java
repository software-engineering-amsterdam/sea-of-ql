package org.uva.sea.ql.ast.expression.literal;

import org.uva.sea.ql.ast.expression.Expression;

/**
 * Represents a literal expression.
 */
abstract public class Literal extends Expression {
	@Override
	abstract public String toString();
}
