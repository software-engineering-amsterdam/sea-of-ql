package org.uva.sea.ql.ast;

public class Neg {
	private Expr value;
	
	public Neg(Expr value){
		this.value=value;
	}
	
	public Expr getValue() {
		return value;
	}

}
