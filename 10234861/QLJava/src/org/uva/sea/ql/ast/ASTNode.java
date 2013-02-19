package org.uva.sea.ql.ast;

public interface ASTNode {
	
	public <ReturnType, ParameterType> 
		ReturnType accept(ASTNodeVisitor<ReturnType, ParameterType> visitor, ParameterType param);
}
