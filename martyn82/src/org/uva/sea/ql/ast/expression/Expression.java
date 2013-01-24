package org.uva.sea.ql.ast.expression;

import java.util.Map;

import org.uva.sea.ql.ast.INode;
import org.uva.sea.ql.ast.type.Type;

/**
 * Represents an expression.
 */
abstract public class Expression implements INode {
	/**
	 * Retrieves the data type of the node.
	 *
	 * @param types
	 *
	 * @return The node type.
	 */
	abstract public Type typeOf( Map<Ident, Type> types );
}
