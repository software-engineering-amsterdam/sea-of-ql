package org.uva.sea.ql.ast;

public interface ASTNode {
	void accept(Visitor visitor);
}
