package org.uva.sea.ql.ast;

public abstract class Statement extends ASTNode {
	
	public abstract void accept(StatementVisitor visitor);	
	
}
