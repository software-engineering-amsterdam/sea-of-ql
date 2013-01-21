package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.ast.ASTNodeVisitor;

public abstract class BinaryTree extends Expr {
	
	private Expr lhs;
	private Expr rhs;
	
	protected BinaryTree(Expr lhs, Expr rhs) {
		this.lhs = lhs;
		this.rhs = rhs;
	}
	
	protected BinaryTree(Expr lhs) {
		this.lhs = lhs;
	}
	
	public void accept(ASTNodeVisitor visitor) {
		lhs.accept(visitor);
		if (rhs != null)
			rhs.accept(visitor);
		visitor.visit(this);
    }
	
}
