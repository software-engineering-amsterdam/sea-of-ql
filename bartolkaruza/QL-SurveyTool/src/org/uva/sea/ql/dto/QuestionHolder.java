package org.uva.sea.ql.dto;

import org.uva.sea.ql.ast.Question;

public class QuestionHolder {
	
	private Question question;
	
	public QuestionHolder(Question question) {
		this.question = question;
	}
	
	public Question getQuestion() {
		return question;
	}
}
