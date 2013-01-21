package org.uva.sea.ql.ast.traversal.base;

/**
 * Interface for all nodes that are traversed using the visitor pattern.
 * @author J. Dijkstra
 */
public interface IVisitable {
	/**
	 * Accepts a visitor.
	 * @param visitor visitor that wants to visit the visitable
	 */
	void accept(final IVisitor visitor);
}
