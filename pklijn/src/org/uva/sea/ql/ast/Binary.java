package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.values.Value;

public class Binary extends Expr {
	private Expr left;
	private Expr right;
	
	public Binary(Expr left, Expr right) {
		this.left = left;
		this.right = right;
	}
	
	public Expr getLeft() {
		return left;
	}
	
	public Expr getRight() {
		return right;
	}

	@Override
	public Value eval() {
		throw new UnsupportedOperationException("Can't get a value from a Binary class");
	}
}
