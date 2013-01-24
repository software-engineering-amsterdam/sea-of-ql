package org.uva.sea.ql.ast.expression.literal;

import java.util.Map;

import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.eval.Context;
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
	public <T> T accept( INodeVisitor<T> visitor, Context context ) {
		return visitor.visit( this, context );
	}

	@Override
	public Type typeOf( Map<Ident, Type> types ) {
		return new org.uva.sea.ql.ast.type.Str();
	}
}
