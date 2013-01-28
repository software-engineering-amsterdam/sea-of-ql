package org.uva.sea.ql.ast.statement;

import java.util.List;

import org.uva.sea.ql.ast.Expr;

public class If extends Statement{
	
	private final Expr condition; 
	private final List<Statement> body; 
	
	public If(Expr condition, List<Statement> body){
		this.condition = condition;
		this.body = body;
	}

	public Expr getCondition() {
		return condition;
	}

	public List<Statement> getBody() {
		return body;
	}
	
}
