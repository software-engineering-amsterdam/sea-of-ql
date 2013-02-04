package org.uva.sea.ql.ast;

public class NullStatement implements Statement {

	@Override
	public <ReturnType, ParameterType> ReturnType accept(StatementVisitor<ReturnType, ParameterType> visitor, ParameterType param) {
		return null;
	}

}
