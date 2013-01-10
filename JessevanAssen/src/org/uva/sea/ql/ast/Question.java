package org.uva.sea.ql.ast;

public class Question extends FormElement {

	private final String question;
	private final Ident value;
	private final String type;
	
	public Question(String question, Ident value, String type) {
		this.question = question;
		this.value = value;
		this.type = type;
	}
	
	public String getQuestion() { return question; }
	public Ident getValue() { return value; }
	public String getType() { return type; }

}
