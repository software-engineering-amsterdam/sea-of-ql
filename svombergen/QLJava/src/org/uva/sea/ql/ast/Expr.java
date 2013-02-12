package org.uva.sea.ql.ast;

public abstract class Expr implements ASTNode {
	public String getType(){
		return this.getClass().getSimpleName();
	}

	public void accept(Visitor v){
		;
	}
}
