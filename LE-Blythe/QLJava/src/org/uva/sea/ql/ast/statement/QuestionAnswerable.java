package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.primitive.Undefined;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.visitor.IVisitorStatement;
import org.uva.sea.ql.util.Environment;


public class QuestionAnswerable extends Question{
	
	private Type  type;
	
	
	public QuestionAnswerable(String question, Ident identifier, Type type){
		super(question, identifier);
		this.type = type;
	}
	
	
	@Override
	public Type typeOf(Environment env){
		return type;
	}
	
	
	public Expr getValue(){
		return new Undefined(type);
	}
	
	@Override
	public <T> T accept(IVisitorStatement<T> visitor) {
		return visitor.visit(this);
	}
}
