package org.uva.sea.ql.visitor.evaluator.value;

import org.uva.sea.ql.ast.type.StringType;

/**
 * Represents a string value.
 */
public class StringValue extends Value {
	/**
	 * Holds the inner value.
	 */
	private final java.lang.String value;

	/**
	 * Constructs a new String value.
	 *
	 * @param value
	 */
	public StringValue( java.lang.String value ) {
		this.value = value;
	}

	@Override
	public StringType getType() {
		return new StringType();
	}

	@Override
	public java.lang.String getValue() {
		return this.value;
	}
}
