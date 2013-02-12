package org.uva.sea.ql.ast.value;

import static julius.validation.Assertions.state;

import org.uva.sea.ql.visitor.NaturalVisitor;
import org.uva.sea.ql.visitor.ValuableVisitor;

public class StringValue extends Value<StringValue> {

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
	public StringValue accept(final ValuableVisitor visitor) {
		return visitor.visit(this);
	}

	@Override
	public Nature getNature() {
		return Nature.TEXTUAL;
	}

	@Override
	public String toString() {
		return "StringLiteral [value=" + value + "]";
	}

}
