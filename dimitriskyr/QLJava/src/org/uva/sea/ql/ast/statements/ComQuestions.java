package org.uva.sea.ql.ast.statements;

import org.uva.sea.ql.ast.*;

public class ComQuestions extends Question{
	private Type ident;
	private Type string;
	private Type bool;
	private Expr expression;
	
	public ComQuestions(Type ident, Type string, Type bool, Expr expression){
		this.ident=ident;
		this.string=string;
		this.bool=bool;
		this.expression=expression;
	}
	
	public Type getIdent() {
		return ident;
	}
	
	public Type getString() {
		return string;
	}
	
	public Type getBool() {
		return bool;
	}
	
	public Expr getExpression() {
		return expression;
	}

}
