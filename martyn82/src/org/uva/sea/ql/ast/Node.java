package org.uva.sea.ql.ast;

import org.uva.sea.ql.visitor.NodeVisitor;

/**
 * Represents a node in an AST.
 */
abstract public class Node {
	/**
	 * Visits the node.
	 *
	 * @param visitor
	 */
	abstract public <T> T accept( NodeVisitor<T> visitor );
}
