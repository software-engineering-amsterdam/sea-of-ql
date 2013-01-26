package org.uva.sea.ql.ast.operations;

import org.uva.sea.ql.ast.types.Expr;

public class NEq extends Expr {

	private final Expr value1;
	private final Expr value2;

	public NEq(Expr n,Expr p) {
		this.value1 = n;
		this.value2 = p;
	}

	public boolean getValue() {
		return value1 != value2;
	}
	
}
