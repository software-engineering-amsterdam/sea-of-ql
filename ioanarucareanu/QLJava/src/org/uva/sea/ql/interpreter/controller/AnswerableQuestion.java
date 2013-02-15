package org.uva.sea.ql.interpreter.controller;

import org.uva.sea.ql.ast.expr.value.Value;
import org.uva.sea.ql.ast.ql.Question;


public class AnswerableQuestion {
	
	private Question question;
	private Value<?> answer;  
	
	public AnswerableQuestion(Question question) {
		this.question = question;
		this.answer = question.getType().createValueOfType();
	}

	public Question getQuestion() {
		return question;
	}
	
	public Value<?> getAnswer() {
		return answer;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public void setAnswer(Value<?> answer) {
		this.answer = answer;
	}
	
	

}
