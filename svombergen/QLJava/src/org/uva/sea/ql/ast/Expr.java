package org.uva.sea.ql.ast;

import org.uva.sea.ql.visitor.Visitor;

public abstract class Expr implements ASTNode {
	public String getType(){
		return this.getClass().getSimpleName();
	}

	public void accept(Visitor v){
		;
	}
	
	public boolean isNumeric() {
		return false;
	}
	
	public boolean isBoolean() {
		return false;
	}
	
	public boolean isTextual() {
		return false;
	}
}
