package org.uva.sea.ql.ast.expression.literal;

import org.uva.sea.ql.visitor.IExpressionVisitor;

/**
 * Represents a decimal number.
 */
public class Money extends Number {
	/**
	 * Holds the value of this instance.
	 */
	private final double value;

	/**
	 * Constructs a new Money value.
	 *
	 * @param value The value of the literal.
	 */
	public Money( double value ) {
		this.value = value;
	}

	/**
	 * Retrieves the value of this object.
	 *
	 * @return The value.
	 */
	public double getValue() {
		return this.value;
	}

	@Override
	public String toString() {
		return String.valueOf( this.value );
	}

	@Override
	public <T> T accept( IExpressionVisitor<T> visitor ) {
		return visitor.visit( this );
	}
}
