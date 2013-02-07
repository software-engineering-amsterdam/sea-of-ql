package org.uva.sea.ql.visitor.evaluator.value;

import org.uva.sea.ql.ast.type.StringType;

/**
 * Represents a string value.
 */
public class StringValue extends Value {
	/**
	 * Holds the inner value.
	 */
	private final String value;

	/**
	 * Constructs a new String value.
	 *
	 * @param value
	 */
	public StringValue( String value ) {
		this.value = value;
	}

	@Override
	public StringType getType() {
		return new StringType();
	}

	@Override
	public String getValue() {
		return this.value;
	}
}
