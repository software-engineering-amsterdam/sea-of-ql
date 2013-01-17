package org.uva.sea.ql.ast.expression;

import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.visitor.Visitor;

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
	public void accept( Visitor visitor ) {
		visitor.visit( this );
	}
	
	@Override
	public String toString() {
		return this.name;
	}

	@Override
	public boolean checkType() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Type getType() {
		// TODO Auto-generated method stub
		return null;
	}
}
