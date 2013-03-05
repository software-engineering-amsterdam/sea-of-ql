package org.uva.sea.ql.ast.alg;

import org.uva.sea.ql.ast.Expr;

public abstract class Binary extends Expr {
	private final Expr lhs;
	private final Expr rhs;

	protected Binary(Expr lhs, Expr rhs) {
		this.lhs = lhs;
		this.rhs = rhs;
		//System.out.println(" From Binary");
	}
	
	public Expr getLhs() {
		return lhs;
	}
	
	public Expr getRhs() {
		return rhs;
	}
}
