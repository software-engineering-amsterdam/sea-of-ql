package ast.statement;

import ast.Statement;
import ast.expression.value.Ident;
import ast.visitor.Visitor;

public class Form extends Statement {
	
	private final Ident ident;
	private final Statement content;
	
	public Form(Ident ident, Statement content){
		this.ident = ident;
		this.content = content;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return null; //visitor.visit(this);
	}

	public Ident getIdent() {
		return ident;
	}

	public Statement getContent() {
		return content;
	}


}
