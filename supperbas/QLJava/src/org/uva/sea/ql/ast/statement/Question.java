package org.uva.sea.ql.ast.statement;

import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.expression.value.Str;


public abstract class Question extends Statement {
	
	private final Str label;
	
	public Question(Str label){
		this.label = label;
	}
	
	public Str getLabel(){
		return label;
	}

	abstract public Ident getIdent();

}
