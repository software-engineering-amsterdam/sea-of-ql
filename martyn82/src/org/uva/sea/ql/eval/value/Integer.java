package org.uva.sea.ql.eval.value;

/**
 * Represents an Integer value.
 */
public class Integer extends Number<java.lang.Integer> {
	public Integer( java.lang.Integer value ) {
		super( value );
	}

	public Integer() {
		this( null );
	}
}
