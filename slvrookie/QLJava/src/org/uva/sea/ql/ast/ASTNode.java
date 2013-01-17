package org.uva.sea.ql.ast;

import org.uva.sea.ql.visitor.Visitor;

public interface ASTNode {

	void accept(Visitor visitor);
	
}
