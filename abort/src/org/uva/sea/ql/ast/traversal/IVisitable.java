package org.uva.sea.ql.ast.traversal;

public interface IVisitable {
	void accept(Visitor visitor);
}
