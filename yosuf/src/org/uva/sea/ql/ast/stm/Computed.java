package org.uva.sea.ql.ast.stm;

import static julius.validation.Assertions.state;

import org.uva.sea.ql.ast.exp.Expression;
import org.uva.sea.ql.ast.exp.Identifier;
import org.uva.sea.ql.ast.type.DataType;
import org.uva.sea.ql.visitor.StatementVisitor;

public class Computed extends Block {

	private final Identifier identifier;
	private final DataType dataType;
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

	public DataType getDataType() {
		return dataType;
	}

	public Identifier getIdentifier() {
		return identifier;
	}

	public Expression getExpression() {
		return expression;
	}

	@Override
	public <T> T accept(final StatementVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public String toString() {
		return "Computed [" + identifier + ", " + dataType + ", " + expression
				+ "]";
	}

}
