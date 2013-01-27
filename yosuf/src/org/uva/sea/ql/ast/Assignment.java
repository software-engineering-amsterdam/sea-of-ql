package org.uva.sea.ql.ast;

import static julius.validation.Assertions.state;

import org.uva.sea.ql.ast.exp.Expression;

public class Assignment extends Statement {

	private final Identifier identifier;
	private final Expression expression;

	/**
	 * 
	 * @param identifier
	 *            (not null)
	 * @param expression
	 *            (not null)
	 */
	public Assignment(final Identifier identifier, final Expression expression) {
		this.identifier = identifier;
		this.expression = expression;
		state.assertNotNull(identifier, "Assignment.identifier");
		state.assertNotNull(expression, "Assignment.identifier");
	}

	public Identifier getIdentifier() {
		return identifier;
	}

	public Expression getExpression() {
		return expression;
	}
}
