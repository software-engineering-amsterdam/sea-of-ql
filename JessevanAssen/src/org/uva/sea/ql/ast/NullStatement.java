package org.uva.sea.ql.ast;

public class NullStatement implements Statement {

	@Override
	public <ReturnType, ParameterType> ReturnType accept(ASTNodeVisitor<ReturnType, ParameterType> visitor, ParameterType param) {
		return null;
	}

}
