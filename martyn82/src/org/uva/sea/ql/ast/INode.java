package org.uva.sea.ql.ast;

import org.uva.sea.ql.evaluate.Context;
import org.uva.sea.ql.evaluate.value.Value;
import org.uva.sea.ql.visitor.INodeVisitor;

/**
 * Represents a node in an AST.
 */
public interface INode {
	/**
	 * Evaluates the node.
	 *
	 * @param visitor
	 * @param context
	 *
	 * @return The value of the node.
	 */
	Value accept( INodeVisitor visitor, Context context );
}
