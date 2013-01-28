package org.uva.sea.ql.ast;

import org.uva.sea.ql.visitor.FormVisitor;

public interface ASTNode {
	void accept (FormVisitor visitor);
}
