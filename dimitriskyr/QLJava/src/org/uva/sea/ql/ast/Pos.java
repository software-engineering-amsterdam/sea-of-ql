package org.uva.sea.ql.ast;

public class Pos {
	private Expr value;
	
	public Pos(Expr value){
		this.value=value;
	}
	
	public Expr getValue() {
		return value;
	}

}
