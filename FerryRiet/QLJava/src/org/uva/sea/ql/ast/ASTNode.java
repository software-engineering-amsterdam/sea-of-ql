package org.uva.sea.ql.ast;

import org.uva.sea.ql.astvisitor.ASTNodeVisitor;

public interface ASTNode {
	 void accept(ASTNodeVisitor astNodeVisitor) ;
}
