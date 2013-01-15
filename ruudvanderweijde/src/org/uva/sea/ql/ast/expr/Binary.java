package org.uva.sea.ql.ast.expr;

public abstract class Binary extends Expr {

	private final Expr lhs;
	private final Expr rhs;
	
	protected Binary(Expr lhs, Expr rhs) {
		this.lhs = lhs;
		this.rhs = rhs;
	}
	
	public Expr getLhs() {
		return lhs;
	}
	
	public Expr getRhs() {
		return rhs;
	}
	
	
}
