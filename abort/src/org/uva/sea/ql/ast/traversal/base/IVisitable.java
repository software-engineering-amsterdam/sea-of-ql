package org.uva.sea.ql.ast.traversal.base;

/**
 * Interface for all nodes that are traversed using the visitor pattern
 */
public interface IVisitable {
	void accept(final IVisitor visitor);
}
