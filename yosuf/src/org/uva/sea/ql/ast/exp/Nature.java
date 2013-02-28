package org.uva.sea.ql.ast.exp;

import org.uva.sea.ql.ast.value.Value;

/**
 * Expressions and data types can have a common shared nature which is described by this class.
 */
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