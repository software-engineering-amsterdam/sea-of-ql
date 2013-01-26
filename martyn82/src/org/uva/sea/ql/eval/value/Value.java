package org.uva.sea.ql.eval.value;

/**
 * Represents an abstract value.
 */
abstract public class Value {
	/**
	 * Retrieves the value of the instance.
	 *
	 * @return The value.
	 */
	abstract public <T> T getValue();
}
