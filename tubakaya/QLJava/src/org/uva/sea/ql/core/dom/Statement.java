package org.uva.sea.ql.core.dom;

public abstract class Statement extends ASTNode {
	
	public abstract void accept(StatementVisitor visitor);	
	
}
