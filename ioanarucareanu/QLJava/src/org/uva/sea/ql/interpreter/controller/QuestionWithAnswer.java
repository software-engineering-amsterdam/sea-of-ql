package org.uva.sea.ql.interpreter.controller;

import org.uva.sea.ql.ast.expr.value.UndefinedVal;
import org.uva.sea.ql.ast.expr.value.Val;
import org.uva.sea.ql.ast.ql.Question;


public class QuestionWithAnswer {
	
	private Question question;
	private Val answer;  
	private boolean editable;
	
	public QuestionWithAnswer(Question question, boolean editable) {
		this.question = question;
		this.answer = new UndefinedVal();
		this.editable = editable;
	}
	
	public QuestionWithAnswer(Question question, Val answer) {
		this.question = question;
		this.answer = answer;
		editable = true;
	}
	
	public QuestionWithAnswer(Question question, Val answer, boolean editable) {
		this.question = question;
		this.answer = answer;
		this.editable = editable;
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

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}
	
	

}
