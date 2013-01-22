package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.ast.ASTNodeVisitor;

public abstract class Binary extends Expr {
	
	private Expr lhs;
	private Expr rhs;
	
	protected Binary(Expr lhs, Expr rhs) {
		this.lhs = lhs;
		this.rhs = rhs;
	}
	
	protected Binary(Expr lhs) {
		this.lhs = lhs;
	}
	
	public Expr getLhs() {
		return lhs;
	}
	
	public Expr getRhs() {
		return rhs;
	}
	
	@Override
	public <T> T accept(ASTNodeVisitor<T> visitor) {
		lhs.accept(visitor);
		if (rhs != null)
			rhs.accept(visitor);
		return visitor.visit(this);
    }
	
}
