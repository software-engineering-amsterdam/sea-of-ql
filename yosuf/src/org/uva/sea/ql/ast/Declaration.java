package org.uva.sea.ql.ast;

import static julius.validation.Assertions.state;

import org.uva.sea.ql.ast.exp.Expression;
import org.uva.sea.ql.ast.type.DataType;

public class Declaration extends Statement {
	private final DataType dataType;
	private final Identifier identifier;
	private final Expression expression;

	/**
	 * 
	 * @param dataType
	 *            (not null)
	 * @param identifier
	 *            (not null)
	 * @param expression
	 *            (not null)
	 */
	public Declaration(final DataType dataType, final Identifier identifier,
			final Expression expression) {
		this.dataType = dataType;
		this.identifier = identifier;
		this.expression = expression;

		state.assertNotNull(this.dataType, "Declaration.dataType");
		state.assertNotNull(this.identifier, "Declaration.identifier");
		state.assertNotNull(this.expression, "Declaration.expression");
	}

}
