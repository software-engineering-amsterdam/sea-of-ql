package org.uva.sea.ql.ast.exp;

import static julius.validation.Assertions.state;

public abstract class Unary<T> extends Expression<T> {

	private final Expression<T> operation;

	/**
	 * 
	 * @param operation
	 *            (not null)
	 */
	public Unary(final Expression<T> operation) {
		this.operation = operation;
		state.assertNotNull(operation, "Unary.operation");
	}

	public Expression<T> getOperation() {
		return operation;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "[operation=" + operation
				+ ", Nature=" + getNature() + "]";
	}

}
