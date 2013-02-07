package org.uva.sea.ql.visitor.evaluator.value;

import org.uva.sea.ql.ast.type.Str;

/**
 * Represents a string value.
 */
public class String extends Value {
	/**
	 * Holds the inner value.
	 */
	private final java.lang.String value;

	/**
	 * Constructs a new String value.
	 *
	 * @param value
	 */
	public String( java.lang.String value ) {
		this.value = value;
	}

	@Override
	public Str getType() {
		return new Str();
	}

	@Override
	public java.lang.String getValue() {
		return this.value;
	}
}
