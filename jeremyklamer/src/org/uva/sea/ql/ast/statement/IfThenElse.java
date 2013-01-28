package org.uva.sea.ql.ast.statement;

import java.util.List;

import org.uva.sea.ql.ast.Expr;

public class IfThenElse extends Statement{
	
	private final Expr condition;
	private final List<Statement> ifBody; 
	private final List<Statement> elseBody;
	
	public IfThenElse(Expr condition, List<Statement> ifBody, List<Statement> elseBody){
		this.condition = condition;
		this.ifBody = ifBody;
		this.elseBody = elseBody;
	}
	
	public Expr getCondition() {
		return condition;
	}
	public List<Statement> getElseBody() {
		return elseBody;
	}
	public List<Statement> getIfBody() {
		return ifBody;
	}
}
