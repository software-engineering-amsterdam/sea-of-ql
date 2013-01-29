package ast.statement;

import java.util.Map;

import ast.Statement;
import ast.type.*;
import ast.visitor.Visitor;

public class Else extends Statement {
	
	private final Statement consequence;
	
	public Else(Statement consequence){
		this.consequence = consequence;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return null; //visitor.visit(this);
	}
	
	public Statement getConsequence(){
		return this.consequence;
	}

	@Override
	public Type typeOf(Map<ast.type.Ident, Type> typeEnv) {
		// TODO Auto-generated method stub
		return null;
	}

}
