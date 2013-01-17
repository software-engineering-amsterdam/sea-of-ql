package org.uva.sea.ql.ast.statement;

import java.util.List;

import org.uva.sea.ql.ast.Expr;

public class IfThenElse extends Statement{
	
	private final Expr conditionIf;
	private final List<Statement> ifStatements;
	private final List<Statement> elseStatements;
	
	public IfThenElse(Expr conditionIf, List<Statement> ifStatements, List<Statement> elseStatements)
	{
		this.conditionIf = conditionIf;
		this.ifStatements = ifStatements;
		this.elseStatements = elseStatements;
	}
	
	public Expr getConditionIf() {
		return conditionIf;
	}
	public List<Statement> getElseStatements() {
		return elseStatements;
	}
	public List<Statement> getIfStatements() {
		return ifStatements;
	}
}
