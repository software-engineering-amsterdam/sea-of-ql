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
	
	public void accept(ASTNodeVisitor visitor) {
		lhs.accept(visitor);
		if (rhs != null)
			rhs.accept(visitor);
		visitor.visit(this);
    }
	
}
