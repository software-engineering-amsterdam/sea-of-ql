package org.uva.sea.ql.eval.value;

/**
 * Represents a Boolean value.
 */
public class Boolean extends Value {
	/**
	 * Holds the inner value.
	 */
	private final java.lang.Boolean value;

	/**
	 * Constructs a new Boolean value.
	 *
	 * @param value
	 */
	public Boolean( java.lang.Boolean value ) {
		this.value = value;
	}

	@Override
	public java.lang.Boolean getValue() {
		return this.value;
	}
}
