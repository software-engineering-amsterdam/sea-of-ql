package org.uva.sea.ql.ast.statements;

import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.visitor.Visitor;

public class ComQuestion extends Statement{
	private Value ident;
	private Value string;
	private Type bool;
	private Expr expression;
	
	public ComQuestion(Value ident, Value string, Type bool, Expr expression){
		this.ident=ident;
		this.string=string;
		this.bool=bool;
		this.expression=expression;
	}
	
	public Value getIdent() {
		return ident;
	}
	
	public Value getString() {
		return string;
	}
	
	public Type getBool() {
		return bool;
	}
	
	public Expr getExpression() {
		return expression;
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
