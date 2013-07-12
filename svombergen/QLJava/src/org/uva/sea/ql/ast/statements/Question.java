package org.uva.sea.ql.ast.statements;

import org.uva.sea.ql.ast.primaryexpr.Ident;
import org.uva.sea.ql.ast.primaryexpr.Str;
import org.uva.sea.ql.ast.statements.types.*;
import org.uva.sea.ql.ast.value.Value;
import org.uva.sea.ql.visitor.IFormVisitor;


public abstract class Question implements Statement {
	
	protected Ident ident;
	protected Str questionString;
	protected Type type;
	protected Value<?> value;

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
	
	public void setVisible(boolean b) {
		throw new NullPointerException();
	}

	@Override
	public abstract <T> T accept(IFormVisitor<T> v);

	public Value<?> getValue() {
		return value;
	}
	
	public void setValue(Value<?> v) {
		value = v;
	}
	
}
