package org.uva.sea.ql.ast.exp;

import static julius.validation.Assertions.state;

import org.uva.sea.ql.ast.Valuable;

public abstract class Unary extends Expression implements Valuable {

	private final Expression operation;

	/**
	 * 
	 * @param operation
	 *            (not null)
	 */
	public Unary(final Expression operation) {
		this.operation = operation;
		state.assertNotNull(operation, "Unary.operation");
	}

	public Expression getOperation() {
		return operation;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "[operation=" + operation
				+ ", Nature=" + getNature() + "]";
	}

}
