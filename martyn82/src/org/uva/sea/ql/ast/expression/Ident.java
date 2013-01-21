package org.uva.sea.ql.ast.expression;

import org.uva.sea.ql.eval.Context;
import org.uva.sea.ql.visitor.INodeVisitor;

/**
 * Represents an identifier expression.
 */
public class Ident extends Expression {
	/**
	 * Holds the name of the identifier.
	 */
	private final String name;

	/**
	 * Constructs a new identifier expression.
	 *
	 * @param name The name of the identifier.
	 */
	public Ident( String name ) {
		this.name = name;
	}

	/**
	 * Retrieves the name of the identifier.
	 *
	 * @return The name of the identifier.
	 */
	public String getName() {
		return this.name;
	}

	@Override
	public String toString() {
		return this.name;
	}

	@Override
	public <T> T accept( INodeVisitor<T> visitor, Context context ) {
		return visitor.visit( this, context );
	}
}
