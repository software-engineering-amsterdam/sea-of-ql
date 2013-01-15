package org.uva.sea.ql.ast;

public abstract class BinaryExpr extends Expr{
	
	private final Expr lhs;
	private final Expr rhs;

	protected BinaryExpr(Expr lhs, Expr rhs) {
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
