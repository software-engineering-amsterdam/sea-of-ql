package org.uva.sea.ql.ast.operations;

import org.uva.sea.ql.ast.types.Expr;

public class Pos extends Expr {

	private final Expr value;

	public Pos(Expr n) {
		this.value = n;
	}

	public Expr getValue() {
		return value;
	}
	
}
