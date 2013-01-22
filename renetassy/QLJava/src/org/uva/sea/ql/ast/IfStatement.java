package org.uva.sea.ql.ast;

public class IfStatement extends Statement {
	
	private Expr condition;
	private Body content;
	
	public IfStatement (Expr condition, Body content) {
		this.condition=condition;
		this.content=content;
	}

}
