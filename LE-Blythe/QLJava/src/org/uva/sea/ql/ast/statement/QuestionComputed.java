package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.IVisitorStatement;
import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.util.Environment;


public class QuestionComputed extends Question{
	
	private Expr expression;
	
	public QuestionComputed(String question, Ident identifier, Expr value){
		super(question, identifier);
		this.expression = value;
	}
	
	public  Expr getExpression(){
		return expression;
	}
	

	public Type typeOf(Environment<Ident, Type> env){
		return expression.typeOf(env);
	}
	
	
	@Override
	public <T> T accept(IVisitorStatement<T> visitor) {
		return visitor.visit(this);
	}
}
