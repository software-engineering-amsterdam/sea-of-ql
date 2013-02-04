package org.uva.sea.ql.ast;

import static julius.validation.Assertions.state;

import org.uva.sea.ql.ast.exp.Expression;
import org.uva.sea.ql.visitor.ASTNodeVisitor;

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

	@Override
	public void accept(final ASTNodeVisitor visitor) {
		// TODO Auto-generated method stub

	}

}
