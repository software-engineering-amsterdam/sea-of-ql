package org.uva.sea.ql.ast.statements;

import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.visitor.IFormVisitor;

public abstract class AStatement implements ASTNode {
	
	public abstract <T> T accept(IFormVisitor<T> visitor); 
}