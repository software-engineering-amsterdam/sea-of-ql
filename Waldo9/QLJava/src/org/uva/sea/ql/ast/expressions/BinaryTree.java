package org.uva.sea.ql.ast.expressions;

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
	
	protected Expr getLeft() {
		return lhs;
	}
	
	protected Expr getRight() {
		return rhs;
	}
	
}
