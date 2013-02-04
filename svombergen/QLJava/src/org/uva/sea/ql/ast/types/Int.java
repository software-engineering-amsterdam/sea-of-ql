package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.Expr;

public class Int extends Expr {

	private final int value;

	public Int(int n) {
		this.value = n;
	}

	public int getValue() {
		return value;
	}
	
	@Override
	public String toString(){
		return "" + getValue();
	}
	
}
