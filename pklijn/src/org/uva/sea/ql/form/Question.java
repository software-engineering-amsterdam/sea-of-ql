package org.uva.sea.ql.form;

public class Question extends FormItem {

	private String id;
	private String question;
	private String questionType;
	
	public Question(String id, String question, String questionType) {
		this.id = id;
		this.question = question;
		this.questionType = questionType;
	}
	
	public String getId() {
		return id;
	}
	
	public String getQuestion() {
		return question;
	}
	
	public String getQuestionType() {
		return questionType;
	}

	@Override
	public void print(int level) {
		printIndent(level);
		System.out.println("Q:" + question 
				+ " (id: " + id 
				+ ", type: " + questionType + ")");
	}
}
