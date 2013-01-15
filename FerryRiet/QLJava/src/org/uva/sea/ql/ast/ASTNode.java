package org.uva.sea.ql.ast;

import org.uva.sea.ql.astnodevisitor.Visitor;

public interface ASTNode {
	 void accept(Visitor astNodeVisitor) ;
}
