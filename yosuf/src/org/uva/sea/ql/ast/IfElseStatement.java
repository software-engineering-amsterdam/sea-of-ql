package org.uva.sea.ql.ast;

import static julius.validation.Assertions.state;

import org.uva.sea.ql.ast.exp.Expression;

public class IfElseStatement extends IfStatement {

	private final CompoundStatement elseCompound;

	public IfElseStatement(final Expression expression,
			final CompoundStatement ifCompound,
			final CompoundStatement elseCompound) {
		super(expression, ifCompound);
		this.elseCompound = elseCompound;
		state.assertNotNull(elseCompound, "elseCompound");
	}

	public CompoundStatement getCompoundStatement() {
		return elseCompound;
	}
}
