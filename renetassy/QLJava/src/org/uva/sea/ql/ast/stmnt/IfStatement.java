package org.uva.sea.ql.ast.stmnt;

import org.uva.sea.ql.ast.expr.Expr;

public class IfStatement extends Statement {
	
	private Expr condition;
	private Body content;
	
	public IfStatement (Expr condition, Body content) {
		this.condition=condition;
		this.content=content;
	}

}
