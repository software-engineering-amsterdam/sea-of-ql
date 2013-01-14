package org.uva.sea.ql.ast;

import org.uva.sea.ql.interpreter.Value;

public class Int extends Expr {

	private final int value;

	public Int(int n) {
		this.value = n;
	}

	public int getValue() {
		return value;
	}

	@Override
	public Value interpret() {
		return new org.uva.sea.ql.interpreter.Int(this.value);
	}
	
}
