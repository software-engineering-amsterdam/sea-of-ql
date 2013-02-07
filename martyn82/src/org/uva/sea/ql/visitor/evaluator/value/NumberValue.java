package org.uva.sea.ql.visitor.evaluator.value;

/**
 * Represents a numeric value.
 */
abstract public class NumberValue extends Value {
	/**
	 * Holds the inner value.
	 */
	private final java.lang.Number value;

	/**
	 * Constructs a new Number value.
	 *
	 * @param value
	 */
	public NumberValue( java.lang.Number value ) {
		this.value = value;
	}

	@Override
	public java.lang.Number getValue() {
		return this.value;
	}
}