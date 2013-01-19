package org.uva.sea.ql.ast;

public class IfStatement extends Statement {

	private final Expr condition;
	private final Statement truePath;

	public IfStatement(Expr condition, Statement truePath) {
		this.condition = condition;
		this.truePath = truePath;
	}
	
	public Statement getTruePath() {
		return this.truePath;
	}
	
	public Expr getCondition() {
		return this.condition;
	}
}
