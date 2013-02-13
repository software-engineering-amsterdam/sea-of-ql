package org.uva.sea.ql.ast.statements;

import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.ast.Type;
import org.uva.sea.ql.ast.Value;
import org.uva.sea.ql.ast.visitor.IStatementVisitor;


public class Question extends Statement {
	private Value ident;
	private Value string;
	private Type bool;
	
	public Question(Value ident, Value string, Type bool){
		this.ident=ident;
		this.string=string;
		this.bool=bool;
	}
	

	public Value getIdent() { 
		return ident;
	}
	
	public Value getString() {
		return string;
	}
	
	public Type getBoolean() {
		return bool;
	}

	@Override
	public void accept(IStatementVisitor visitor) {
		visitor.visit(this);
	}
}
