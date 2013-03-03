package org.uva.sea.ql.ast.value;

import static julius.validation.Assertions.state;

import org.uva.sea.ql.ast.NaturalVisitor;
import org.uva.sea.ql.ast.exp.ExpressionVisitor;
import org.uva.sea.ql.ast.exp.Nature;
import org.uva.sea.ql.ast.exp.Textual;

public class StringValue extends Value {

	private final String value;

	/**
	 * 
	 * @param value
	 *            (not null)
	 */
	public StringValue(final String value) {
		super();
		this.value = value;
		state.assertNotNull(this.value, "StringLiteral.value");
	}

	public String getValue() {
		return value;
	}

	@Override
	public <T> T accept(final NaturalVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Value accept(final ExpressionVisitor visitor) {
		return visitor.visit(this);
	}

	@Override
	public Nature getNature() {
		return new Textual();
	}

	@Override
	public String toString() {
		return "StringLiteral [value=" + value + "]";
	}

	@Override
	public String getAsString() {
		return value;
	}

}
