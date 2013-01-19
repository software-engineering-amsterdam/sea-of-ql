package org.uva.sea.ql.ast;

import org.uva.sea.ql.visitor.INodeVisitor;

/**
 * Represents a node in an AST.
 */
public interface INode {
	/**
	 * Accepts a visitor.
	 *
	 * @param visitor
	 */
	void accept( INodeVisitor visitor );
}
