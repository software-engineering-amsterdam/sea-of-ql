package org.uva.sea.ql.eval.value;

/**
 * Represents an Integer value.
 */
public class Integer extends Number {
	/**
	 * Holds the inner value.
	 */
	private final java.lang.Integer value;

	/**
	 * Constructs a new Integer value.
	 *
	 * @param value
	 */
	public Integer( java.lang.Integer value ) {
		super( value );
		this.value = value;
	}

	@Override
	public java.lang.Integer getValue() {
		return this.value;
	}
}
