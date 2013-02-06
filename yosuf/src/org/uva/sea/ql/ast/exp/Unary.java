package org.uva.sea.ql.ast.exp;

import static julius.validation.Assertions.state;

public abstract class Unary extends Expression {

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
		return getClass() + "[operation=" + operation + ", Nature="
				+ getNature() + "]";
	}

}
