package org.uva.sea.ql.ast;

import static julius.validation.Assertions.state;

import org.uva.sea.ql.ast.exp.Expression;
import org.uva.sea.ql.ast.exp.Identifier;
import org.uva.sea.ql.ast.type.DataType;

public class Computed extends Statement {

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
	public Computed(final DataType dataType, final Identifier identifier,
			final Expression expression) {

		this.dataType = dataType;
		this.identifier = identifier;
		this.expression = expression;

		state.assertNotNull(this.dataType, "Computed.dataType");
		state.assertNotNull(this.identifier, "Computed.identifier");
		state.assertNotNull(this.expression, "Computed.expression");
	}
}
