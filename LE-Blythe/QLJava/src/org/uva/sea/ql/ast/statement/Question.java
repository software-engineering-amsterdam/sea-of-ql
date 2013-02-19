package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.util.Environment;


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

	public abstract Type typeOf(Environment env);
	public abstract Expr getValue(); 
}
