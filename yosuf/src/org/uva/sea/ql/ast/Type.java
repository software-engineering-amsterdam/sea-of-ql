package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.value.Value;

public abstract class Type {

	/**
	 * Validates the given input string for the type.
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