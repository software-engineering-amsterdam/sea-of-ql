package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.Statement;


public abstract class Question extends Statement{
	
	private String question;
	private Ident identifier;
	
	public Question(String question, Ident identifier){
		this.question = question;
		this.identifier = identifier;
	}
	
	
	public Ident getIdentifier(){
		return identifier;
	}
	
	
	public String getQuestion(){
		return question;
	}
}
