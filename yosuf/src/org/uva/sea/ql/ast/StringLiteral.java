package org.uva.sea.ql.ast;

import static julius.validation.Assertions.state;

public class StringLiteral implements ASTNode {
	private final String value;

	/**
	 * 
	 * @param value
	 *            (not null)
	 */
	public StringLiteral(final String value) {
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
