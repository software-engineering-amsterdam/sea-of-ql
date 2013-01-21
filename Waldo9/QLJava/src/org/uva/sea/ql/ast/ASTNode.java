package org.uva.sea.ql.ast;

public interface ASTNode {
	
	public void accept(ASTNodeVisitor visitor);

}
