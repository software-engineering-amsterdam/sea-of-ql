package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.types.*;

public class Question extends Statement {
	
	protected Ident ident;
	protected Str questionString;
	protected Type type;

	public Question(Ident id, Str q, Type t) {
		ident = id;
		questionString = q;
		type = t;
	}
	
	public Ident getIdent(){
		return ident;
	}
	
	public Str getQuestionString(){
		return questionString;
	}
	
	public Type getType(){
		return type;
	}
	
	@Override
	public void accept(Visitor v){
		v.visit(this);
	}
}
