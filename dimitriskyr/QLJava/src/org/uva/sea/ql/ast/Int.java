package org.uva.sea.ql.ast;

public class Int extends Expr {
	private final int value;
	
	public Int (int value){
		this.value=value;
	}
	
	public int getValue() {
		return value;
	}

}
