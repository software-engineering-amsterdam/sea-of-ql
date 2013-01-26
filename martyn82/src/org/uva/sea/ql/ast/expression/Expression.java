package org.uva.sea.ql.ast.expression;

import java.util.Map;

import org.uva.sea.ql.ast.Node;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.visitor.IExpressionVisitor;

/**
 * Represents an expression.
 */
abstract public class Expression extends Node {
	/**
	 * Accept a visitor.
	 *
	 * @param visitor
	 */
	abstract public <T> T accept( IExpressionVisitor<T> visitor );

	abstract public Type typeOf( Map<Ident, Type> types );
}
