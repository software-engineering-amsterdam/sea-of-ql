package org.uva.sea.ql.ast.operators;

import org.uva.sea.ql.ast.Expr;

public abstract class Binary extends Expr {

	private final Expr lhs, rhs;
	
	protected Binary(Expr lhs, Expr rhs) {
		this.lhs = lhs;
		this.rhs = rhs;
	}
	
	protected Expr getLhs() {
		return lhs;
	}
	
	protected Expr getRhs() {
		return rhs;
	}

}