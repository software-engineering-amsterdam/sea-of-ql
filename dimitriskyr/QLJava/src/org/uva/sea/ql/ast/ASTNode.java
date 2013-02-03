package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.visitor.Visitor;


public interface ASTNode {
	public void accept(Visitor visitor);
}
