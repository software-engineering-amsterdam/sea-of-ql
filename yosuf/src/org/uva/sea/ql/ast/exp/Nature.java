package org.uva.sea.ql.ast.exp;

import org.uva.sea.ql.ast.value.Value;

public abstract class Nature {

	/**
	 * Validates the given input string for the nature.
	 * 
	 * @param input
	 * @return
	 */
	public abstract boolean isValidInput(String input);

	/**
	 * This method returns a value matching to the. isValidValue can be used for validation.
	 * 
	 * @param value
	 * @return
	 */
	public abstract Value createValue(String value);
}