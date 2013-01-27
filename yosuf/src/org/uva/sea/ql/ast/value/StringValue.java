package org.uva.sea.ql.ast.value;

import static julius.validation.Assertions.state;

public class StringValue extends Value {

	private final String value;

	/**
	 * 
	 * @param value
	 *            (not null)
	 */
	public StringValue(final String value) {
		this.value = value;
		state.assertNotNull(this.value, "StringLiteral.value");
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "StringLiteral [value=" + value + "]";
	}

}
