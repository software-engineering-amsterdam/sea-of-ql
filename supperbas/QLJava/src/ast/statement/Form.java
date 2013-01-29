package ast.statement;

import java.util.Map;

import ast.Statement;
import ast.type.Ident;
import ast.type.Type;
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

	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		// TODO Auto-generated method stub
		return null;
	}

	public Ident getIdent() {
		return ident;
	}

	public Statement getContent() {
		return content;
	}

}
