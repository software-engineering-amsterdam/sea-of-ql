package org.uva.sea.ql.ast.type;

public class Question extends Type {	
	
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
