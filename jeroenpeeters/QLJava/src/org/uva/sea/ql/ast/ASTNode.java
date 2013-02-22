package org.uva.sea.ql.ast;

import org.uva.sea.ql.visitor.ASTVisitor;

public interface ASTNode {

	void accept(ASTVisitor visitor);
	
}