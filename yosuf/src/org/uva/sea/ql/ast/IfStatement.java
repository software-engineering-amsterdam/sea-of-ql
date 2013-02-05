package org.uva.sea.ql.ast;

import static julius.validation.Assertions.state;

import org.uva.sea.ql.ast.exp.Expression;

public class IfStatement extends Statement {

	private final Expression expression;
	private final CompoundStatement ifCompound;

	/**
	 * 
	 * @param expression
	 *            (not null)
	 * @param compound
	 *            (not null)
	 */
	public IfStatement(final Expression expression,
			final CompoundStatement compound) {

		this.expression = expression;
		ifCompound = compound;

		state.assertNotNull(this.expression, "IfStatement.expression");
		state.assertNotNull(ifCompound, "IfStatement.compound");
	}

	public CompoundStatement getIfCompound() {
		return ifCompound;
	}

}
