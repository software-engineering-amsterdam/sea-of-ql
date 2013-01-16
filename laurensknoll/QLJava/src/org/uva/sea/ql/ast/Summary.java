package org.uva.sea.ql.ast;

public class Summary extends Statement {

	private final Statement question;
	private final Expr expression;

	public Summary(Statement question, Expr expression) {
		this.question = question;
		this.expression = expression;
	}
	
	public Statement getQuestion() {
		return this.question;
	}

	public Expr getExpression() {
		return this.expression;
	}
	
}
