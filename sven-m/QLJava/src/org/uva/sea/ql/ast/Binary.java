package org.uva.sea.ql.ast;

public abstract class Binary extends Expr implements ASTNode {
	protected final Expr lhs;
	protected final Expr rhs;
	
	public Binary(Expr lhs, Expr rhs) {
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
