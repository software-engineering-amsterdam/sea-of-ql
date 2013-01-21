package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.visitor.Visitorinterface;


public interface ASTNode {
	public void accept(Visitorinterface visitor);
}
