package ast.expression;

import ast.Expression;

public abstract class Value extends Expression {

	public Value() {
	}


	public abstract String toString();

	public boolean isDefined() {
		return true;
	}
	
	public String typeStr(){ return null; }

}
