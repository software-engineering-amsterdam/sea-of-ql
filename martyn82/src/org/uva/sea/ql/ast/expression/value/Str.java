package org.uva.sea.ql.ast.expression.value;

import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.visitor.NodeVisitor;

/**
 * Represents a string literal expression.
 */
public class Str extends Literal {
	private static final Type TYPE = new org.uva.sea.ql.ast.type.Str();
	
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
	public void accept( NodeVisitor visitor ) {
		visitor.visit( this );
	}

	@Override
	public boolean checkType() {
		return true;
	}

	@Override
	public Type getType() {
		return TYPE;
	}
}
