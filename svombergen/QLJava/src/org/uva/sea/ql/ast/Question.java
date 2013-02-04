package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.types.*;

public class Question extends Statement {
	
	protected Ident name;
	protected Str questionString;
	protected Type type;

	public Question(Ident id, Str q, Type t) {
		name = id;
		questionString = q;
		type = t;
	}
	
	public Ident getName(){
		return name;
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
