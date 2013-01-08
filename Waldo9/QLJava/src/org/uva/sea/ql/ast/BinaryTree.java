package org.uva.sea.ql.ast;

public abstract class BinaryTree extends Expr {
	
	private Expr left;
	private Expr right;
	
	protected BinaryTree(Expr left, Expr right) {
		this.left = left;
		this.right = right;
	}
	
	protected Expr getLeft() {
		return left;
	}
	
	protected Expr getRight() {
		return right;
	}
	
}
