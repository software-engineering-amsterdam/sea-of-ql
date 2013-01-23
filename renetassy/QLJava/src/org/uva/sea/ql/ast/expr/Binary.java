package org.uva.sea.ql.ast.expr;

public class Binary extends Expr {
	
	private Expr lhs;
	private Expr rhs;
	
	public Binary (Expr lhs, Expr rhs) {
		this.lhs=lhs;
		this.rhs=rhs;
	}
	
	protected Expr getLeft() {	
		return lhs;
	}
	
	protected Expr getRight() {
		return rhs;
	}
}
