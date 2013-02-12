package org.uva.sea.ql.ast.exp;

import static julius.validation.Assertions.state;

/**
 * Since binary expressions can be evaluated to one literal value type and the left-hand-side and
 * right-hand-side can be another literal value type, two types are defined to support both.
 * 
 * @param <T>
 *            literal value type which the expression finally returns
 * @param <U>
 *            literal value type of the left-hand-side and right-hand-side
 */
public abstract class Binary<T, U> extends Expression<T> {

	private final Expression<U> left;
	private final Expression<U> right;

	/**
	 * 
	 * @param left
	 *            (not null)
	 * @param right
	 *            (not null)
	 */
	protected Binary(final Expression<U> left, final Expression<U> right) {
		this.left = left;
		this.right = right;
		state.assertNotNull(this.left, "Expression.left");
		state.assertNotNull(this.right, "Expression.right");
	}

	public Expression<U> getLeft() {
		return left;
	}

	public Expression<U> getRight() {
		return right;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [left=" + left + ", right="
				+ right + ", Nature=" + getNature() + "]";
	}

}
