package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.type.Type;

public class Question extends Statement {	
	
	private final String sentence; 
	private final Type returnType; 
	
	public Question(String sentence , Type returnType){
		this.sentence = sentence;
		this.returnType = returnType;
	}

	public String getSentence() {
		return sentence;
	}

	public Type getReturnType() {
		return returnType;
	}
}
