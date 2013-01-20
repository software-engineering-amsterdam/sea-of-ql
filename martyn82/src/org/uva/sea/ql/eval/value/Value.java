package org.uva.sea.ql.eval.value;

/**
 * Represents an abstract value.
 */
abstract public class Value<T> {
	/**
	 * Holds the inner value.
	 */
	private T value;

	/**
	 * Constructs a new Value object.
	 *
	 * @param value
	 */
	public Value( T value ) {
		this.value = value;
	}

	/**
	 * Constructs a new null value object.
	 */
	public Value() {
		this( null );
	}

	/**
	 * Retrieves the inner value of this value.
	 *
	 * @return The value.
	 */
	public T getValue() {
		return this.value;
	}

	/**
	 * Sets a new value to this value object.
	 *
	 * @param value
	 */
	public void setValue( T value ) {
		this.value = value;
	}
}
