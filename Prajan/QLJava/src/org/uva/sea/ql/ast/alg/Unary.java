package org.uva.sea.ql.ast.alg;

import org.uva.sea.ql.ast.Expr;

public abstract class Unary extends Expr {

	private final Expr value;
	
	protected Unary(Expr value){
		this.value = value;
	}
	
	public Expr getValue(){
		return value;
	}
	
}
