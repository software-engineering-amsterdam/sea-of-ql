package org.uva.sea.ql.ast;

public class Not {
	private Expr value;
	
	public Not(Expr value){
		this.value=value;
	}
	
	public Expr getValue() {
		return value;
	}

}
