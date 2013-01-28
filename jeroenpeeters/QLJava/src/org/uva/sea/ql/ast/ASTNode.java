package org.uva.sea.ql.ast;

import org.uva.sea.ql.parser.ASTVisitor;

public interface ASTNode {

	void accept(ASTVisitor visitor);
	
}
