package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.values.Value;

public class Int extends Expr {

	private final int value;

	public Int(int n) {
		this.value = n;
	}

	public int getValue() {
		return value;
	}

	@Override
	public Value eval() {
		return new org.uva.sea.ql.ast.values.Int(value);
		// TODO Auto-generated method stub
		//return null;
	}
	
}
