package org.uva.sea.ql.ast.traversal.base;

/**
 * Interface for all nodes that are traversed using the visitor pattern.
 * @author J. Dijkstra
 */
public interface IVisitable {
	/**
	 * @param visitor visitor that wants to visit the visitable
	 * @return return return value predefined in the accept method
	 */
	<T> T accept(final IVisitor<T> visitor);
}
