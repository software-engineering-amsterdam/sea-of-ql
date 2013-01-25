package org.uva.sea.ql.ast;

import org.uva.sea.ql.visitor.NodeVisitor;

/**
 * Represents a node in an AST.
 */
public interface INode {
	/**
	 * Evaluates the node.
	 *
	 * @param visitor
	 */
	<T> T accept( NodeVisitor<T> visitor );
}
