package org.uva.sea.ql.eval.value;

/**
 * Represents a numeric value.
 *
 * @param <T>
 */
abstract public class Number<T> extends Value<T> {
	public Number( T value ) {
		super( value );
	}

	public Number() {
		this( null );
	}
}
