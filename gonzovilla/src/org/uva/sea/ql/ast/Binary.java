package org.uva.sea.ql.ast;

public abstract class Binary extends Expr {
	private Expr lhs;
	private Expr rhs;

	public Binary(Expr lhs, Expr rhs) {
		this.lhs = lhs;
		this.rhs = rhs;
	}

	public Expr getLeft() {
		return lhs;
	}

	public Expr getRight() {
		return rhs;
	}
	
	@Override
	public Value eval() {
		// TODO Auto-generated method stub
		return null;
	}
}
