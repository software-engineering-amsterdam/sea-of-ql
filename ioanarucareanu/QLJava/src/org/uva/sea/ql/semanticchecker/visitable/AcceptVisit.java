package org.uva.sea.ql.semanticchecker.visitable;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.semanticchecker.Visitor;

public interface AcceptVisit<T extends ASTNode, S extends Visitor> { 
	
	void act(T visitableElement, S visitor);
}
