package org.uva.sea.ql.eval.value;

/**
 * Represents a numeric value.
 */
abstract public class Number extends Value {
	/**
	 * Holds the inner value.
	 */
	private final java.lang.Number value;

	/**
	 * Constructs a new Number value.
	 *
	 * @param value
	 */
	public Number( java.lang.Number value ) {
		this.value = value;
	}

	@Override
	public java.lang.Number getValue() {
		return this.value;
	}
}