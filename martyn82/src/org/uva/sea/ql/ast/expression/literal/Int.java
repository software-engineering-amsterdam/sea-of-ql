package org.uva.sea.ql.ast.expression.literal;

import org.uva.sea.ql.evaluate.Context;
import org.uva.sea.ql.evaluate.value.Value;
import org.uva.sea.ql.visitor.INodeVisitor;

/**
 * Represents an integer expression.
 */
public class Int extends Number {
	/**
	 * Holds the integer value of the expression.
	 */
	private final int value;

	/**
	 * Constructs a new integer expression.
	 *
	 * @param value The value of the expression.
	 */
	public Int( int value ) {
		this.value = value;
	}

	/**
	 * Retrieves the value of the expression.
	 *
	 * @return The value.
	 */
	public int getValue() {
		return this.value;
	}

	@Override
	public String toString() {
		return String.valueOf( this.value );
	}

	@Override
	public Value accept( INodeVisitor visitor, Context context ) {
		return visitor.visit( this, context );
	}
}
