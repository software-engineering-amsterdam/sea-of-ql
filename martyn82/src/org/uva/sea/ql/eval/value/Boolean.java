package org.uva.sea.ql.eval.value;

/**
 * Represents a Boolean value.
 */
public class Boolean extends Value<java.lang.Boolean> {
	public Boolean( java.lang.Boolean value ) {
		super( value );
	}

	public Boolean() {
		this( null );
	}
}
