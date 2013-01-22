package org.uva.sea.ql.form;

import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.values.Value;

public class ComputedQuestion extends Question {

	private final Expr expression;
	
	public ComputedQuestion(String id, String question, Value questionType, Expr expression) {
		super(id,question,questionType);
		this.expression = expression;
	}
	
	public Expr getExpression() {
		return expression;
	}
	
	@Override
	public void print(int level) {
		printIndent(level);
		System.out.println("Q:" + getLabel() 
				+ " (id: " + getId() 
				+ ", type: " + getQuestionType ()
				+ ", expression: " + expression + ")");
	}
}
