package org.uva.sea.ql.form;

import org.uva.sea.ql.ast.values.Value;

public class Question extends FormItem {

	private final String id;
	private final String label;
	private final Value questionType;
	
	public Question(String id, String question, Value questionType) {
		this.id = id;
		this.label = question;
		this.questionType = questionType;
	}
	
	public String getId() {
		return id;
	}
	
	public String getLabel() {
		return label;
	}
	
	public Value getQuestionType() {
		return questionType;
	}

	@Override
	public void print(int level) {
		printIndent(level);
		System.out.println("Q:" + label 
				+ " (id: " + id 
				+ ", type: " + questionType + ")");
	}
}
