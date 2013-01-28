package org.uva.sea.ql.eval.value;

/**
 * Represents a Money value.
 */
public class Money extends Number<java.lang.Double> {
	public Money( java.lang.Double value ) {
		super( value );
	}

	public Money() {
		this( null );
	}
}
