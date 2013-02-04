package org.uva.sea.ql.ast;

import org.uva.sea.ql.visitor.IFormVisitor;

public interface ASTNode {
	void accept (IFormVisitor visitor);
}
