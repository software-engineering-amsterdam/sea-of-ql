package org.uva.sea.ql.ast;

public class computedQuestion extends Question {
	
	private Expr expr;

	public computedQuestion(Ident id, StringLiteral label, QuestionType type, Expr expr) {
		super(id, label, type);
		this.expr=expr;
	}

}
