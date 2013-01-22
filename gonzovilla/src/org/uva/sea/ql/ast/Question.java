package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.types.ReturnType;

public class Question extends FormUnit {

	private String ident;
	private String question;
	private ReturnType returnType;
	
	public Question(String ident, String question, ReturnType returnType) {
		this.ident = ident;
		this.question = question;
		this.returnType = returnType;
	}

	public String getIdent() {
		return ident;
	}

	public String getQuestion() {
		return question;
	}

	public ReturnType getReturnType() {
		return returnType;
	}

}
