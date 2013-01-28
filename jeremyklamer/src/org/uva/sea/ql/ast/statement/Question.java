package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.type.Type;

public class Question extends Statement {	
	
	private final Ident name; 
	private final String sentence; 
	private final Type returnType; 
	
	//TODO Kan twee keer in tavbel voorkomen als zelfde type. 
	
	public Question(Ident ident, String sentence , Type returnType){
		this.name = ident; 
		this.sentence = sentence;
		this.returnType = returnType;
	}

	public Ident getName() {
		return name;
	}
	
	public String getSentence() {
		return sentence;
	}

	public Type getReturnType() {
		return returnType;
	}
	
}
