package org.uva.sea.ql.ast.expr;

public abstract class Binary extends Expr {
	
	private Expr lhs;
	private Expr rhs;

	protected Binary(Expr lhs, Expr rhs) {
		this.lhs=lhs;
		this.rhs=rhs;
	}
	
	public Expr getLeft() {	
		return lhs;
	}
	
	public Expr getRight() {
		return rhs;
	}
}
