package org.uva.sea.ql.ast;

public class Question extends Statement {

	private final String ident;
	private final String question;
	private final Type type;

	public Question(String ident, String question, Type type) {
		this.ident = ident;
		this.question = question;
		this.type = type;
	}
	
	public String getQuestion() {
		return this.question;
	}

	public String getIdent() {
		return this.ident;
	}
	
	public Type getType() {
		return this.type;
	}

}
