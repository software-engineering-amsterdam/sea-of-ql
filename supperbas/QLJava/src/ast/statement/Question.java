package ast.statement;

import ast.Statement;
import ast.expression.value.Str;
import ast.expression.value.Ident;

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
