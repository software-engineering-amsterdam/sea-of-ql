package org.uva.sea.ql.ast.operations;

import org.uva.sea.ql.ast.types.Expr;

public class Neg extends Expr {

	private final Expr value;

	public Neg(Expr n) {
		this.value = n;
	}

	public Expr getValue() {
		return value;
	}
	
}
