package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.expr.AbstractExpr;

public class Int extends AbstractExpr {

	private final int value;

	public Int(int n) {
		this.value = n;
	}

	public int getValue() {
		return this.value;
	}
	
}
