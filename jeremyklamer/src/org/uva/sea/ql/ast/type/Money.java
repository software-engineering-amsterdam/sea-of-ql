package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.ast.Expr;

public class Money extends Type {
	
	private Expr amount; 

	public Money(){
		this.amount = null;
	}
	
	public Money(Expr amount){
		this.amount = amount;
	}
	
	public Expr getAmount(){
		return this.amount;
	}

}
