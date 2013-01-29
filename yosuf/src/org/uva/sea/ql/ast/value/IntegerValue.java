package org.uva.sea.ql.ast.value;

import static julius.validation.Assertions.state;

public class IntegerValue extends Value {

	private final int value;

	/**
	 * 
	 * @param value
	 *            (not null)
	 */
	public IntegerValue(final int value) {
		this.value = value;
		state.assertNotNull(this.value, "Integer.value");
	}

	public int getValue() {
		return value;
	}

}
