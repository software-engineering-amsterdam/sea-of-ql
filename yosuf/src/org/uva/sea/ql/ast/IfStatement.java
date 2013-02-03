package org.uva.sea.ql.ast;

import static julius.validation.Assertions.state;

import org.uva.sea.ql.ast.exp.Expression;
import org.uva.sea.ql.visitor.ASTNodeVisitor;

public class IfStatement implements ASTNode {

	private final Expression expression;
	private final CompoundStatement compound;

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
		this.compound = compound;

		state.assertNotNull(this.expression, "IfStatement.expression");
		state.assertNotNull(this.compound, "IfStatement.compound");
	}

	@Override
	public void accept(final ASTNodeVisitor visitor) {
		visitor.visit(this);
	}

}
