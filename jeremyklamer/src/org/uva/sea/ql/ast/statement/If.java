package org.uva.sea.ql.ast.statement;

import java.util.List;

import org.uva.sea.ql.ast.Expr;

public class If extends Statement{
	
	private final Expr condition; 
	private final List<Statement> statements; 
	
	public If(Expr condition, List<Statement> statements){
		this.condition = condition;
		this.statements = statements;
	}

	public Expr getCondition() {
		return condition;
	}

	public List<Statement> getStatements() {
		return statements;
	}
	
}
