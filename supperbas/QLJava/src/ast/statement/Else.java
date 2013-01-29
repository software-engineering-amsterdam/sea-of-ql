package ast.statement;

import ast.Statement;
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
}
