package org.uva.sea.ql.ast.expression.literal;

import org.uva.sea.ql.eval.Context;
import org.uva.sea.ql.eval.value.Value;
import org.uva.sea.ql.visitor.INodeVisitor;

/**
 * Represents a string literal expression.
 */
public class Str extends Literal {
	/**
	 * Holds the value of the literal.
	 */
	private final String value;

	/**
	 * Constructs a new String literal.
	 *
	 * @param value
	 */
	public Str( String value ) {
		this.value = value;
	}

	/**
	 * Retrieves the value of the literal.
	 *
	 * @return The value.
	 */
	public String getValue() {
		return this.value;
	}

	@Override
	public String toString() {
		return this.value;
	}

	@Override
	public Value<?> accept( INodeVisitor visitor, Context context ) {
		return visitor.visit( this, context );
	}
}