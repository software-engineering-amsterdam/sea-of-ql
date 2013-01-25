package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.interfaces.IVisitor;


public class Question extends Statement{
	
	private String question;
	private Ident identifier;
	private Expr  value;
	
	
	public Question(String question, Ident identifier, Expr value){
		this.question = question;
		this.identifier = identifier;
		this.value = value;
	}
	
	
	public Ident getIdentifier(){
		return identifier;
	}
	
	
	public String getQuestion(){
		return question;
	}
	
	
	public  Expr getValue(){
		return value;
	}
	
	
	@Override
	public <T> T accept(IVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
