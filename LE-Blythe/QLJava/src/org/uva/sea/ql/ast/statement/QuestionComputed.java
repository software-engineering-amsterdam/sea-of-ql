package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.interfaces.IVisitorStatement;
import org.uva.sea.ql.util.Environment;


public class QuestionComputed extends Question{
	
	private Expr  value;
	
	public QuestionComputed(String question, Ident identifier, Expr value){
		super(question, identifier);
		this.value = value;
	}
	
	public  Expr getValue(){
		return value;
	}
	

	public Type typeOf(Environment env){
		return value.typeOf(env);
	}
	
	
	@Override
	public <T> T accept(IVisitorStatement<T> visitor) {
		return visitor.visit(this);
	}
}
