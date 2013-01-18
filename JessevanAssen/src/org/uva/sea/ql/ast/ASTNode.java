package org.uva.sea.ql.ast;

import org.uva.sea.ql.ASTNodeVisitor;

public interface ASTNode {
	public <ReturnType, ParameterType> ReturnType accept(ASTNodeVisitor<ReturnType, ParameterType> visitor, ParameterType param);
}
