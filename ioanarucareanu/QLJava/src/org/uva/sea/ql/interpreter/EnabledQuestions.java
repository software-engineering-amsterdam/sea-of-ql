package org.uva.sea.ql.interpreter;

import org.uva.sea.ql.ast.expr.value.Val;
import org.uva.sea.ql.ast.ql.Question;
import org.uva.sea.ql.interpreter.controller.QuestionWithAnswer;
import org.uva.sea.ql.semanticchecker.ReturnType;

import java.util.ArrayList;
import java.util.List;

public class EnabledQuestions implements ReturnType {
	
	private List<QuestionWithAnswer> questions;
	
	public EnabledQuestions() {
		questions = new ArrayList<QuestionWithAnswer>();  
	}
	
	public EnabledQuestions(List<QuestionWithAnswer> questions) {
		questions = new ArrayList<QuestionWithAnswer>(questions);  
	}

	public List<QuestionWithAnswer> getQuestions() {
		return questions;
	}
	
	public void addQuestion(Question question) {
		questions.add(new QuestionWithAnswer(question, true));
	}
	
	public void addQuestionWithAnswer(Question question, Val answer, boolean editable) {
		questions.add(new QuestionWithAnswer(question, answer, editable));
	}
	
	public void addAll(EnabledQuestions enabledQuestions) {
		this.questions.addAll(enabledQuestions.getQuestions());
	}

	public void setQuestions(List<QuestionWithAnswer> questions) {
		this.questions = questions;
	}

}
