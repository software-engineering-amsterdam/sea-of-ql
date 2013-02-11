package org.uva.sea.ql.ast.stm;

import static julius.validation.Assertions.state;

import org.uva.sea.ql.ast.exp.Expression;
import org.uva.sea.ql.visitor.StatementVisitor;

public class IfStatement extends Block {

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

	public Expression getExpression() {
		return expression;
	}

	public CompoundStatement getIfCompound() {
		return ifCompound;
	}

	@Override
	public <T> T accept(final StatementVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public String toString() {
		return "IfStatement [expression=" + expression + ", ifCompound="
				+ ifCompound + "]";
	}

}
