package org.uva.sea.ql.ast.expressions;


public abstract class Binary extends Expr {
	
	private final Expr lhs;
	private final Expr rhs;
	
	protected Binary(Expr lhs, Expr rhs) {
		this.lhs = lhs;
		this.rhs = rhs;
	}
	
	protected Binary(Expr lhs) {
		this.lhs = lhs;
		this.rhs = null;
	}
	
	public Expr getLhs() {
		return lhs;
	}
	
	public Expr getRhs() {
		return rhs;
	}
	
	@Override
	public abstract <T> T accept(ExprVisitor<T> visitor);
	
}
