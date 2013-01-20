package org.uva.sea.ql.parser;

import org.uva.sea.ql.ast.ASTNode;

public interface ASTVisitor {
	
	void visit(ASTNode node);
	
}
