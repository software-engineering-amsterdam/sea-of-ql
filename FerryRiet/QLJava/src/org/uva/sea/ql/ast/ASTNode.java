package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.nodevisitor.Visitor;
import org.uva.sea.ql.ast.nodevisitor.VisitorResult;

public interface ASTNode {
	 VisitorResult accept(Visitor astNodeVisitor) ;
}
