package org.uva.sea.ql.ast.expression;

import java.util.Map;

import org.uva.sea.ql.ast.Node;
import org.uva.sea.ql.ast.type.Type;

/**
 * Represents an expression.
 */
abstract public class Expression implements Node {
	/**
	 * Retrieves the data type of the node.
	 *
	 * @param types
	 *
	 * @return The node type.
	 */
	abstract public Type typeOf( Map<Ident, Type> types );
}
