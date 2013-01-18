package org.uva.sea.ql.form;

import org.uva.sea.ql.ast.Expr;

public class ComputedQuestion extends Question {

	private Expr expression;
	
	public ComputedQuestion(String id, String question, String questionType, Expr expression) {
		super(id,question,questionType);
		this.expression = expression;
	}
	
	public Expr getExpression() {
		return expression;
	}
	
	@Override
	public void print(int level) {
		printIndent(level);
		System.out.println("Q:" + getQuestion() 
				+ " (id: " + getId() 
				+ ", type: " + getQuestionType ()
				+ ", expression: " + expression + ")");
	}
}
