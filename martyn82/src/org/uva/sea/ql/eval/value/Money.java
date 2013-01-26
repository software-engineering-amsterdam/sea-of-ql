package org.uva.sea.ql.eval.value;

/**
 * Represents a Money value.
 */
public class Money extends Number {
	private final java.lang.Double value;

	public Money( java.lang.Double value ) {
		super( value );
		this.value = value;
	}

	@Override
	public java.lang.Double getValue() {
		return this.value;
	}
}
