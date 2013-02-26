package org.uva.sea.ql.ast.exp;

import static julius.validation.Assertions.state;

public abstract class Binary extends Expression {

	private final Expression left;
	private final Expression right;

	/**
	 * 
	 * @param left
	 *            (not null)
	 * @param right
	 *            (not null)
	 */
	protected Binary(final Expression left, final Expression right) {
		this.left = left;
		this.right = right;
		state.assertNotNull(this.left, "Expression.left");
		state.assertNotNull(this.right, "Expression.right");
	}

	public Expression getLeft() {
		return left;
	}

	public Expression getRight() {
		return right;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [left=" + left + ", right="
				+ right + ", Nature=" + getNature() + "]";
	}

}
