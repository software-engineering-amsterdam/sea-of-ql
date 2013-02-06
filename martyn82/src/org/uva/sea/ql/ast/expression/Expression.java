package org.uva.sea.ql.ast.expression;

import org.uva.sea.ql.ast.Node;
import org.uva.sea.ql.visitor.ExpressionVisitor;

/**
 * Represents an expression.
 */
abstract public class Expression extends Node {
	/**
	 * Accept a visitor.
	 *
	 * @param visitor
	 */
	abstract public <T> T accept( ExpressionVisitor<T> visitor );
}
