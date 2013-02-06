package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.visitor.FormVisitor;

public interface FormNode extends ASTNode {
	public <T> T accept(FormVisitor<T> visitor);
}
