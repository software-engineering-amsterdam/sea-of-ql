package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.IVisitorStatement;
import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.type.Type;


public class QuestionAnswerable extends Question{
	
	private Type type;
	
	public QuestionAnswerable(String question, Ident identifier, Type type){
		super(question, identifier);
		this.type = type;
	}
	
	
	public Type getType(){
		return type;
	}
	
	
	@Override
	public <T> T accept(IVisitorStatement<T> visitor) {
		return visitor.visit(this);
	}
}
