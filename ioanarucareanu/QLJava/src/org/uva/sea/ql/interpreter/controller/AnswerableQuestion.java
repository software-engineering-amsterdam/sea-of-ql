package org.uva.sea.ql.interpreter.controller;

import org.uva.sea.ql.ast.expr.value.Val;
import org.uva.sea.ql.ast.ql.Question;


public class AnswerableQuestion {
	
	private Question question;
	private Val answer;  
	
	public AnswerableQuestion(Question question) {
		this.question = question;
		this.answer = question.getType().createValOfType();
		
	}

	public Question getQuestion() {
		return question;
	}
	
	public Val getAnswer() {
		return answer;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public void setAnswer(Val value) {
		this.answer = value;
		
	}
	
	
	

}
