package org.uva.sea.ql.ast;

public interface ASTNode {
	<T> T accept(Visitor<T> visitor);
}
