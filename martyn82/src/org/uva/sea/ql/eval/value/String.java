package org.uva.sea.ql.eval.value;

/**
 * Represents a string value.
 */
public class String extends Value<java.lang.String> {
	public String( java.lang.String value ) {
		super( value );
	}

	public String() {
		this( null );
	}
}
