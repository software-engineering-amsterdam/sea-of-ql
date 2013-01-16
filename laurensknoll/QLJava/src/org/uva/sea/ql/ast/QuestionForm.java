package org.uva.sea.ql.ast;

public class QuestionForm extends Expr {

	private final Statement statement;

	public QuestionForm(Statement statement) {
		this.statement = statement;
	}
	
	public Statement getStatements() {
		return this.statement;
	}
	
}
