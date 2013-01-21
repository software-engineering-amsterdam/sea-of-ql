package org.uva.sea.ql.ast;

public interface ASTNode {
	
	public <T> T accept(ASTNodeVisitor<T> visitor);

}
