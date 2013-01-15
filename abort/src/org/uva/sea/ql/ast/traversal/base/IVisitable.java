package org.uva.sea.ql.ast.traversal.base;

public interface IVisitable {
	void accept(final IVisitor visitor);
}
