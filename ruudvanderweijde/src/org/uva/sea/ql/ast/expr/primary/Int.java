package org.uva.sea.ql.ast.expr.primary;

import org.uva.sea.ql.ast.expr.Expr;


public class Int extends Expr {

	private final int value;

	public Int(int n) {
		this.value = n;
	}

	public int getValue() {
		return value;
	}
	
}
