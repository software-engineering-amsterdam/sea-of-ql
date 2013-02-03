package org.uva.sea.ql.ast.expression.literal;

import org.uva.sea.ql.visitor.IExpressionVisitor;

/**
 * Represents a boolean literal expression.
 */
public class Bool extends Literal {
	/**
	 * Holds the value of the boolean literal.
	 */
	private final boolean value;

	/**
	 * Constructs a new boolean expression.
	 *
	 * @param value The value.
	 */
	public Bool( boolean value ) {
		this.value = value;
	}

	/**
	 * Retrieves the value of the expression.
	 *
	 * @return The value.
	 */
	public boolean getValue() {
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
