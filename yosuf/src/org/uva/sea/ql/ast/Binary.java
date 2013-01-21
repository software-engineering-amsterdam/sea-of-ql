package org.uva.sea.ql.ast;

public abstract class Binary extends Expression {

	private final Expression left;
	private final Expression right;

	protected Binary(final Expression left, final Expression right) {
		this.left = left;
		this.right = right;
	}

	public Expression getLeft() {
		return left;
	}

	public Expression getRight() {
		return right;
	}
}
