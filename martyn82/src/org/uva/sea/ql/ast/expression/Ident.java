package org.uva.sea.ql.ast.expression;

import java.util.Map;

import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.visitor.NodeVisitor;

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
	public int hashCode() {
		return this.name.hashCode();
	}

	@Override
	public boolean equals( Object object ) {
		if ( !( object instanceof Ident ) ) {
			return false;
		}
		return this.name.equals( ( (Ident) object ).name );
	}

	@Override
	public String toString() {
		return this.name;
	}

	@Override
	public <T> T accept( NodeVisitor<T> visitor ) {
		return visitor.visit( this );
	}

	@Override
	public Type typeOf( Map<Ident, Type> types ) {
		if ( types.containsKey( this ) ) {
			return types.get( this );
		}

		return null;
	}
}
