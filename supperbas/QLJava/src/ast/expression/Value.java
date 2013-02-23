package ast.expression;

import java.util.ArrayList;

import ast.Expression;

public abstract class Value<T> extends Expression {

	public Value() {
	}


	public abstract String toString();

	public boolean isDefined() {
		return true;
	}
	
	public String typeStr(){ return null; }
	public abstract T getValue();
	

	
	public ArrayList<Ident> getIdents(){
		return new ArrayList<Ident>();
	}

}
